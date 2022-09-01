package com.example.bll.order.bo;

import java.util.List;

import com.example.dal.order.entity.PurchaseOrder;
import com.example.dal.order.entity.PurchaseOrderDetail;

import lombok.Value;

@Value
public class PurchaseOrderBO {
	private final PurchaseOrder order;
	private final List<PurchaseOrderDetail> details;
}
