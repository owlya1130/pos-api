package com.example.bll.order.bo;

import java.util.List;

import com.example.dal.order.entity.SellOrder;
import com.example.dal.order.entity.SellOrderDetail;
import com.example.dal.order.entity.SellOrderPayment;

import lombok.Value;

@Value
public class SellOrderBO {
	private final SellOrder order;
	private final List<SellOrderDetail> details;
	private final List<SellOrderPayment> payments;
}
