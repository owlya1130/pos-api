package com.example.bll.order;

import java.util.List;

import com.example.bll.order.bo.StockinOrderBO;
import com.example.dal.order.entity.StockinOrder;

public interface StockinOrderSvc {
	public StockinOrderBO save(StockinOrderBO stockinOrderBO);
	public List<StockinOrder> findAll();
	public StockinOrderBO findByOrderUid(Integer orderUid);
}
