package com.example.dal.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dal.config.entity.Payment;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Integer> {
}
