package com.example.dal.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dal.order.entity.ExchangeOrder;

@Repository
public interface ExchangeOrderDao extends JpaRepository<ExchangeOrder, Integer> {
}
