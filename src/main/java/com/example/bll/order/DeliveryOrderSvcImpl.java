package com.example.bll.order;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bll.order.bo.DeliveryOrderBO;
import com.example.bll.product.ProductQuantitySvc;
import com.example.dal.order.DeliveryOrderDao;
import com.example.dal.order.DeliveryOrderDetailDao;
import com.example.dal.order.entity.DeliveryOrder;

@Service
public class DeliveryOrderSvcImpl implements DeliveryOrderSvc {
	@Autowired
	DeliveryOrderDao deliveryOrderDao;
	@Autowired
	DeliveryOrderDetailDao deliveryOrderDetailDao;
	
	@Autowired
	ProductQuantitySvc productQuantitySvc;

	@Override
	public List<DeliveryOrder> findAll() {
		return deliveryOrderDao.findAll();
	}

	@Override
	public DeliveryOrderBO findByOrderUid(Integer orderUid) {
		return new DeliveryOrderBO(
				deliveryOrderDao.findById(orderUid).get(),
				deliveryOrderDetailDao.findByDeliveryUid(orderUid));
	}

	@Override
	@Transactional
	public DeliveryOrderBO save(DeliveryOrderBO deliveryOrderBO) {
		Integer orderUid = deliveryOrderDao.save(deliveryOrderBO.getOrder()).getDeliveryUid();
		deliveryOrderBO.getDetails().stream()
			.forEach(detail -> {
				detail.setDeliveryUid(orderUid);
				deliveryOrderDetailDao.save(detail);
			});
		
		return findByOrderUid(orderUid);
	}

	@Override
	@Transactional
	public DeliveryOrderBO pack(DeliveryOrderBO deliveryOrderBO) {
		DeliveryOrder order = deliveryOrderBO.getOrder();
		order.pack();
		deliveryOrderDao.save(order);
		
		deliveryOrderBO.getDetails().stream()
			.forEach(detail -> {
				deliveryOrderDetailDao.save(detail);				
				productQuantitySvc
					.findByProductUidAndStoreUid(
						detail.getProductUid(), 
						order.getSrcStoreUid())
					.addQuantity((detail.getDeliveryQuantity() * -1));				
			});
		return findByOrderUid(order.getDeliveryUid());
	}

	@Override
	@Transactional
	public DeliveryOrderBO receive(DeliveryOrderBO deliveryOrderBO) {
		DeliveryOrder order = deliveryOrderBO.getOrder();
		order.close();
		deliveryOrderDao.save(order);
		
		deliveryOrderBO.getDetails().stream()
			.forEach(detail -> {
				Integer diffQty = detail.getDeliveryQuantity() - detail.getReceiveQuantity();
				productQuantitySvc
					.findByProductUidAndStoreUid(
						detail.getProductUid(), 
						order.getSrcStoreUid())
					.addQuantity(diffQty);
				
				deliveryOrderDetailDao.save(detail);
				productQuantitySvc
					.findByProductUidAndStoreUid(
						detail.getProductUid(), 
						order.getDstStoreUid())
					.addQuantity(detail.getReceiveQuantity());
			});

		return findByOrderUid(order.getDeliveryUid());
	}

}
