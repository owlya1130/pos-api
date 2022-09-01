package com.example.bll.order;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bll.config.PaymentSvc;
import com.example.bll.member.MemberSvc;
import com.example.bll.order.bo.SellOrderBO;
import com.example.bll.order.bo.SellOrderInvalidBO;
import com.example.bll.product.ProductQuantitySvc;
import com.example.bll.product.ProductSvc;
import com.example.bll.store.StoreSvc;
import com.example.dal.config.entity.Payment;
import com.example.dal.member.entity.Member;
import com.example.dal.order.SellOrderDao;
import com.example.dal.order.SellOrderDetailDao;
import com.example.dal.order.SellOrderPaymentDao;
import com.example.dal.order.entity.SellOrder;
import com.example.dal.order.entity.SellOrderPayment;
import com.example.dal.product.entity.Product;
import com.example.dal.product.entity.ProductQuantity;

@Service
public class SellOrderSvcImpl implements SellOrderSvc {
	@Autowired
	private SellOrderDao sellOrderDao;
	@Autowired
	private SellOrderDetailDao sellOrderDetailDao;
	@Autowired
	private SellOrderPaymentDao sellOrderPaymentDao;

	@Autowired
	private ProductSvc productSvc;
	@Autowired
	private ProductQuantitySvc productQuantitySvc;
	@Autowired
	private PaymentSvc paymentSvc;
	@Autowired
	private StoreSvc storeSvc;
	@Autowired
	private MemberSvc memberSvc;
	
	private Integer mps2dollor = 4; // chiashin 4點換1元
	private Integer dollors2mp = 100; // chiashin 100元換1點

	@Override
	public List<SellOrder> findAll() {
		return sellOrderDao.findAll();
	}

	@Override
	public SellOrderBO findByOrderUid(Integer orderUid) {
		return new SellOrderBO(
				sellOrderDao.findById(orderUid).get(),
				sellOrderDetailDao.findBySellUid(orderUid),
				sellOrderPaymentDao.findBySellUid(orderUid));
	}

	@Override
	@Transactional
	public SellOrderBO save(SellOrderBO sellOrderBO) {
		SellOrder order = sellOrderDao.save(sellOrderBO.getOrder());
		sellOrderBO.getDetails().stream()
			.forEach(detail -> {
				sellOrderDetailDao.save(detail);
				Product product = productSvc.findByProductUid(detail.getProductUid()).getProduct();
				if(!product.isService()) {
					ProductQuantity productQuantity = 
							productQuantitySvc.findByProductUidAndStoreUid(product.getProductUid(), order.getStoreUid());
					productQuantity.addQuantity((detail.getQuantity() * -1));
					if(productQuantity.getQuantity() < 0 && !product.isAllowSellInsufficient()) {
						throw new RuntimeException(product.getName() + " not allow sell insufficient.");
					}
				}
			});
		
		return findByOrderUid(order.getSellUid());
	}

	@Override
	@Transactional
	public SellOrderInvalidBO invalidOrder(Integer orderUid) {
		SellOrderBO sellOrderBO = findByOrderUid(orderUid);
		sellOrderBO.getOrder().invalidOrder();
		
		Map<Integer, Payment> paymentConfigs = 
				paymentSvc.findAll().stream()
					.collect(Collectors.toMap(Payment::getPaymentUid, Function.identity()));
		
		Member member = null;
		if(sellOrderBO.getOrder().getMemberUid() != null) {
			member = memberSvc.findByMemberUid(sellOrderBO.getOrder().getMemberUid());
		}
		
		if(member != null) {
			Integer totalPriceCanDollars2MP = 
						sellOrderBO.getPayments().stream()
							.filter(payment -> 
								!paymentConfigs
									.get(payment.getPaymentUid())
									.getPaymentId()
									.equals("member-point"))
							.map(payment -> payment.getPrice())
							.reduce(0, Integer::sum);
			Integer newMPs = (int) Math.floor(totalPriceCanDollars2MP / dollors2mp);
			member.addMemberPoint((newMPs * -1));
		}
		
		SellOrderInvalidBO sellOrderInvalidBO = new SellOrderInvalidBO();
		for(SellOrderPayment payment: sellOrderBO.getPayments()) {
			String paymentId = paymentConfigs.get(payment.getPaymentUid()).getPaymentId();
			if(paymentId.equals("credit-card")) {
				sellOrderInvalidBO.setReturnCredCard(payment.getPrice());
			} else if(paymentId.equals("cash")) {
				storeSvc
					.findByStoreUid(sellOrderBO.getOrder().getStoreUid())
					.addCash((payment.getPrice() * -1));
				sellOrderInvalidBO.setReturnCash(payment.getPrice());
			} else if(paymentId.equals("stored-cash")) {
				member.addStoredCash(payment.getPrice());
			} else if(paymentId.equals("member-point")) {
				member.addMemberPoint(payment.getPrice() * mps2dollor);				
			}
		}

		return sellOrderInvalidBO;
	}

	@Override
	@Transactional
	public SellOrderBO addPayment(Integer orderUid, SellOrderPayment sellOrderPayment) {
		SellOrder order = sellOrderDao.findById(orderUid).get();
		sellOrderPayment.setSellUid(order.getSellUid());
		sellOrderPaymentDao.save(sellOrderPayment);
		
		Map<Integer, Payment> paymentConfigs = 
				paymentSvc.findAll().stream()
					.collect(Collectors.toMap(Payment::getPaymentUid, Function.identity()));
		
		Member member = null;
		if(order.getMemberUid() != null) {
			member = memberSvc.findByMemberUid(order.getMemberUid());
		}
		
		String paymentId = paymentConfigs.get(sellOrderPayment.getPaymentUid()).getPaymentId();
		if(paymentId.equals("cash")) {
			storeSvc
				.findByStoreUid(order.getStoreUid())
				.addCash(sellOrderPayment.getPrice());
		} else if (paymentId.equals("member-point")) {
			if(member == null) {
				throw new RuntimeException("the customer is not a member.");
			}
			member.addMemberPoint((mps2dollor * sellOrderPayment.getPrice() * -1));
			if(member.getMemberPoint() < 0) {
				throw new RuntimeException("member points is not enough.");
			}
		} else if (paymentId.equals("stored-cash")) {
			if(member == null) {
				throw new RuntimeException("the customer is not a member.");
			}
			member.addStoredCash((sellOrderPayment.getPrice() * -1));	
			if(member.getStoredCash() < 0) {
				throw new RuntimeException("stored cash is not enough.");
			}		
		}
				
		List<SellOrderPayment> payments = sellOrderPaymentDao.findBySellUid(orderUid);
		Integer totalPaid = payments.stream()
				.map(payment -> payment.getPrice())
				.reduce(0, Integer::sum);
		if(totalPaid.equals(order.getTotalPrice())) {
			order.isClosed();
			if(member != null) {
				Integer totalPriceCanDollars2MP = 
							payments.stream()
								.filter(payment -> 
									!paymentConfigs
										.get(payment.getPaymentUid())
										.getPaymentId()
										.equals("member-point"))
								.map(payment -> payment.getPrice())
								.reduce(0, Integer::sum);
				Integer newMPs = (int) Math.floor(totalPriceCanDollars2MP / dollors2mp);
				member.addMemberPoint(newMPs);
			}
		}	
		
		return findByOrderUid(orderUid);
	}

}
