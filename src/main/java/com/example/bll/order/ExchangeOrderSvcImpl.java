package com.example.bll.order;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bll.order.bo.ExchangeOrderBO;
import com.example.bll.product.ProductQuantitySvc;
import com.example.dal.order.ExchangeOrderDao;
import com.example.dal.order.ExchangeOrderDetailDao;
import com.example.dal.order.ExchangeOrderReceiptDao;
import com.example.dal.order.entity.ExchangeOrder;
import com.example.dal.order.entity.ExchangeOrderDetail;
import com.example.dal.order.entity.ExchangeOrderReceipt;

@Service
public class ExchangeOrderSvcImpl implements ExchangeOrderSvc {
	@Autowired
	private ExchangeOrderDao exchangeOrderDao;
	@Autowired
	private ExchangeOrderDetailDao exchangeOrderDetailDao;
	@Autowired
	private ExchangeOrderReceiptDao exchangeOrderReceiptDao;
	
	@Autowired
	private ProductQuantitySvc productQuantitySvc;
	
	@Override
	@Transactional
	public ExchangeOrderBO save(ExchangeOrderBO exchangeOrderBO) {
		ExchangeOrder order = exchangeOrderDao.save(exchangeOrderBO.getOrder());
		Integer orderUid = order.getExchangeUid();
		exchangeOrderBO.getDetails().stream()
			.forEach(detail -> {
				detail.setExchangeUid(orderUid);
				exchangeOrderDetailDao.save(detail);
				
				productQuantitySvc
				.findByProductUidAndStoreUid(
					detail.getProductUid(), 
					order.getStoreUid())
				.addQuantity((detail.getExchangeQuantity() * -1));
			});
		
		return findByOrderUid(orderUid);
	}
	
	@Override
	public ExchangeOrderBO findByOrderUid(Integer orderUid) {
		return new ExchangeOrderBO(
				exchangeOrderDao.findById(orderUid).get(), 
				exchangeOrderDetailDao.findByExchangeUid(orderUid), 
				exchangeOrderReceiptDao.findByExchangeUid(orderUid));
	}
	
	@Override
	@Transactional
	public ExchangeOrderBO venderPickup(Integer orderUid) {
		ExchangeOrder order = exchangeOrderDao.findById(orderUid).get();
		order.venderTook();
		return findByOrderUid(orderUid);
	}
	
	@Override
	@Transactional
	public ExchangeOrderBO saveProductsReceipt(Integer orderUid, List<ExchangeOrderReceipt> receipts) {
		ExchangeOrderBO exchangeOrderBO = findByOrderUid(orderUid);
		ExchangeOrder order = exchangeOrderBO.getOrder();
		List<ExchangeOrderDetail> details = exchangeOrderBO.getDetails();
		receipts.stream()
			.forEach(receipt -> {
				receipt.setExchangeUid(orderUid);
				exchangeOrderReceiptDao.save(receipt);
				
				details.stream()
					.filter(detail -> 
								detail.getProductUid() == receipt.getProductUid() 
								&& detail.getExchangeQuantity() != detail.getReceiveQuantity())
					.findFirst()
					.get()
					.receive(receipt.getQuantity());
				
				productQuantitySvc
					.findByProductUidAndStoreUid(
						receipt.getProductUid(), 
						order.getStoreUid())
					.addQuantity(receipt.getQuantity());
			});
		
		long unDones = details.stream()
			.map(detail -> detail.getExchangeQuantity() == detail.getReceiveQuantity())
			.filter(isReceiveAll -> isReceiveAll.booleanValue() == false)
			.count();
		if(unDones == 0) {
			order.setClosed(true);
		}		
		
		return findByOrderUid(orderUid);
	}
	
	@Override
	public List<ExchangeOrder> findAll() {
		return exchangeOrderDao.findAll();
	}

}
