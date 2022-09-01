package com.example.dal.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dal.order.entity.ExchangeOrderDetail;

@Repository
public interface ExchangeOrderDetailDao extends JpaRepository<ExchangeOrderDetail, Integer> {
	public List<ExchangeOrderDetail> findByExchangeUid(Integer exchangeUid);
}
