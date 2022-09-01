package com.example.bll.order;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bll.order.bo.PurchaseOrderBO;
import com.example.dal.order.PurchaseOrderDao;
import com.example.dal.order.PurchaseOrderDetailDao;
import com.example.dal.order.entity.PurchaseOrder;
import com.example.dal.order.entity.PurchaseOrderDetail;

@Service
public class PurchaseOrderSvcImpl implements PurchaseOrderSvc {
	@Autowired
	private PurchaseOrderDao purchaseOrderDao;
	@Autowired
	private PurchaseOrderDetailDao purchaseOrderDetailDao;

	@Override
	public List<PurchaseOrder> findAll() {
		return purchaseOrderDao.findAll();
	}

	@Override
	public PurchaseOrderBO findByOrderUid(Integer orderUid) {
		return new PurchaseOrderBO(
				purchaseOrderDao.findById(orderUid).get(),
				purchaseOrderDetailDao.findByPurchaseUid(orderUid));
	}

	@Override
	@Transactional
	public PurchaseOrderBO save(PurchaseOrderBO purchaseOrderBO) {
		PurchaseOrder order = purchaseOrderDao.save(purchaseOrderBO.getOrder());
		for(PurchaseOrderDetail detail: purchaseOrderBO.getDetails()) {
			detail.setPurchaseUid(order.getPurchaseUid());
		}
		purchaseOrderDetailDao.saveAll(purchaseOrderBO.getDetails());

		return findByOrderUid(order.getPurchaseUid());
	}

}
