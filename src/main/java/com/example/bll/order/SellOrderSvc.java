package com.example.bll.order;

import java.util.List;

import com.example.bll.order.bo.SellOrderBO;
import com.example.bll.order.bo.SellOrderInvalidBO;
import com.example.dal.order.entity.SellOrder;
import com.example.dal.order.entity.SellOrderPayment;

public interface SellOrderSvc {
	public List<SellOrder> findAll();
	public SellOrderBO findByOrderUid(Integer orderUid);
	public SellOrderBO save(SellOrderBO sellOrderBO);
	public SellOrderInvalidBO invalidOrder(Integer orderUid);
	public SellOrderBO addPayment(Integer orderUid, SellOrderPayment sellOrderPayment);
}
