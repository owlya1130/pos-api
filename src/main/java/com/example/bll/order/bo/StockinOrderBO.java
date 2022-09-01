package com.example.bll.order.bo;

import java.util.List;

import com.example.dal.order.entity.StockinOrder;
import com.example.dal.order.entity.StockinOrderDetail;

import lombok.Value;

@Value
public class StockinOrderBO {
	private final StockinOrder order;
	private final List<StockinOrderDetail> details;
}
