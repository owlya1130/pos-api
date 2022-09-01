package com.example.bll.order;

import java.util.List;

import com.example.bll.order.bo.ExchangeOrderBO;
import com.example.dal.order.entity.ExchangeOrder;
import com.example.dal.order.entity.ExchangeOrderReceipt;

public interface ExchangeOrderSvc {
	public ExchangeOrderBO save(ExchangeOrderBO exchangeOrderBO);
	public ExchangeOrderBO findByOrderUid(Integer orderUid);
	public ExchangeOrderBO venderPickup(Integer orderUid);
	public ExchangeOrderBO saveProductsReceipt(Integer orderUid, List<ExchangeOrderReceipt> receipts);
	public List<ExchangeOrder> findAll();
	
}
