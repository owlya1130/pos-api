package com.example.bll.order;

import java.util.List;

import com.example.dal.order.entity.StoredCashOrder;

public interface StoredCashOrderSvc {
	public StoredCashOrder save(StoredCashOrder storedCashOrder);
	public List<StoredCashOrder> findAll();
}
