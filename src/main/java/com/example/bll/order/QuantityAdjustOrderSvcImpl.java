package com.example.bll.order;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bll.order.bo.QuantityAdjustOrderBO;
import com.example.bll.product.ProductQuantitySvc;
import com.example.dal.order.QuantityAdjustOrderDao;
import com.example.dal.order.QuantityAdjustOrderDetailDao;
import com.example.dal.order.entity.QuantityAdjustOrder;
import com.example.dal.order.entity.QuantityAdjustOrderDetail;

@Service
public class QuantityAdjustOrderSvcImpl implements QuantityAdjustOrderSvc {
	@Autowired
	private QuantityAdjustOrderDao quantityAdjustOrderDao;
	@Autowired
	private QuantityAdjustOrderDetailDao quantityAdjustOrderDetailDao;
	
	@Autowired
	private ProductQuantitySvc productQuantitySvc;

	@Override
	public List<QuantityAdjustOrder> findAll() {
		return quantityAdjustOrderDao.findAll();
	}

	@Override
	public QuantityAdjustOrderBO findByOrderUid(Integer orderUid) {
		return new QuantityAdjustOrderBO(
				quantityAdjustOrderDao.findById(orderUid).get(),
				quantityAdjustOrderDetailDao.findByQuantityAdjustUid(orderUid));
	}

	@Override
	@Transactional
	public QuantityAdjustOrderBO save(QuantityAdjustOrderBO quantityAdjustOrderBO) {
		Integer orderUid = quantityAdjustOrderDao.save(quantityAdjustOrderBO.getOrder()).getQuantityAdjustUid();
		for(QuantityAdjustOrderDetail detail: quantityAdjustOrderBO.getDetails()) {
			detail.setQuantityAdjustUid(orderUid);
		}
		quantityAdjustOrderDetailDao.saveAll(quantityAdjustOrderBO.getDetails());
		
		return findByOrderUid(orderUid);
	}

	@Override
	@Transactional
	public QuantityAdjustOrderBO audit(Integer orderUid, boolean isApprove) {
		QuantityAdjustOrderBO quantityAdjustOrderBO = findByOrderUid(orderUid);
		QuantityAdjustOrder order = quantityAdjustOrderBO.getOrder();
		order.approve(isApprove);
		
		Integer storeUid = order.getStoreUid();
		if(isApprove) {
			quantityAdjustOrderBO.getDetails().stream()
				.forEach(detail -> {
					productQuantitySvc
						.findByProductUidAndStoreUid(detail.getProductUid(), storeUid)
						.addQuantity(detail.getActualQuantity() - detail.getSystemQuantity());
				});
		}

		return findByOrderUid(orderUid);
	}

}
