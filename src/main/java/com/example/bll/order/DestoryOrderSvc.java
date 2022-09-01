package com.example.bll.order;

import java.util.List;

import com.example.bll.order.bo.DestoryOrderBO;
import com.example.dal.order.entity.DestoryOrder;

public interface DestoryOrderSvc {
	public DestoryOrderBO save(DestoryOrderBO destoryOrderBO);
	public List<DestoryOrder> findAll();
	public DestoryOrderBO findByOrderUid(Integer orderUid);
	public DestoryOrderBO audit(Integer orderUid, boolean isApprove);
	
}
