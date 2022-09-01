package com.example.bll.order;

import java.util.List;

import com.example.bll.order.bo.QuantityAdjustOrderBO;
import com.example.dal.order.entity.QuantityAdjustOrder;

public interface QuantityAdjustOrderSvc {
	public List<QuantityAdjustOrder> findAll();
	public QuantityAdjustOrderBO findByOrderUid(Integer orderUid);
	public QuantityAdjustOrderBO save(QuantityAdjustOrderBO quantityAdjustOrderBO);
	public QuantityAdjustOrderBO audit(Integer orderUid, boolean isApprove);
}
