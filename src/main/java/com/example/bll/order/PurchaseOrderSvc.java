package com.example.bll.order;

import java.util.List;

import com.example.bll.order.bo.PurchaseOrderBO;
import com.example.dal.order.entity.PurchaseOrder;

public interface PurchaseOrderSvc {
	public List<PurchaseOrder> findAll();
	public PurchaseOrderBO findByOrderUid(Integer orderUid);
	public PurchaseOrderBO save(PurchaseOrderBO purchaseOrderBO);
}
