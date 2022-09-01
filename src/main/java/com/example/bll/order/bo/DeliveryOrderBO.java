package com.example.bll.order.bo;

import java.util.List;

import com.example.dal.order.entity.DeliveryOrder;
import com.example.dal.order.entity.DeliveryOrderDetail;

import lombok.Value;

@Value
public class DeliveryOrderBO {
	private final DeliveryOrder order;
	private final List<DeliveryOrderDetail> details;
}
