package com.example.bll.order;

import java.util.List;

import com.example.bll.order.bo.DeliveryOrderBO;
import com.example.dal.order.entity.DeliveryOrder;

public interface DeliveryOrderSvc {
	public List<DeliveryOrder> findAll();
	public DeliveryOrderBO findByOrderUid(Integer orderUid);
	public DeliveryOrderBO save(DeliveryOrderBO deliveryOrderBO);
	public DeliveryOrderBO pack(DeliveryOrderBO deliveryOrderBO);
	public DeliveryOrderBO receive(DeliveryOrderBO deliveryOrderBO);

}
