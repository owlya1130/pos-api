package com.example.bll.order.bo;

import java.util.List;

import com.example.dal.order.entity.DestoryOrder;
import com.example.dal.order.entity.DestoryOrderDetail;

import lombok.Value;

@Value
public class DestoryOrderBO {
	private final DestoryOrder order;
	private final List<DestoryOrderDetail> details;
}
