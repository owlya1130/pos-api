package com.example.bll.order.bo;

import java.util.List;

import com.example.dal.order.entity.ExchangeOrder;
import com.example.dal.order.entity.ExchangeOrderDetail;
import com.example.dal.order.entity.ExchangeOrderReceipt;

import lombok.Value;

@Value
public class ExchangeOrderBO {
	private final ExchangeOrder order;
	private final List<ExchangeOrderDetail> details;
	private final List<ExchangeOrderReceipt> receipts;
}
