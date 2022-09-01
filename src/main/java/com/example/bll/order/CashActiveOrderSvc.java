package com.example.bll.order;

import java.util.List;

import com.example.dal.order.entity.CashActiveOrder;

public interface CashActiveOrderSvc {
	public CashActiveOrder save(Integer storeUid, CashActiveOrder cashActiveOrder);
	public List<CashActiveOrder> findAll();
}
