package com.example.dal.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dal.order.entity.SellOrderPayment;

@Repository
public interface SellOrderPaymentDao extends JpaRepository<SellOrderPayment, Integer> {
	public List<SellOrderPayment> findBySellUid(Integer sellUid);

}
