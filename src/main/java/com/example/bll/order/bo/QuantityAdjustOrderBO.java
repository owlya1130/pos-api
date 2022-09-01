package com.example.bll.order.bo;

import java.util.List;

import com.example.dal.order.entity.QuantityAdjustOrder;
import com.example.dal.order.entity.QuantityAdjustOrderDetail;

import lombok.Value;

@Value
public class QuantityAdjustOrderBO {
	private final QuantityAdjustOrder order;
	private final List<QuantityAdjustOrderDetail> details;
}
