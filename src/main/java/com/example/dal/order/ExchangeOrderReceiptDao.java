package com.example.dal.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dal.order.entity.ExchangeOrderReceipt;

@Repository
public interface ExchangeOrderReceiptDao extends JpaRepository<ExchangeOrderReceipt, Integer> {
	public List<ExchangeOrderReceipt> findByExchangeUid(Integer exchangeUid);
}
