package com.example.bll.config;

import java.util.List;

import com.example.dal.config.entity.Payment;

public interface PaymentSvc {
	public Payment save(Payment payment);
	public Payment update(Payment payment);
	public void delete(Integer paymentUid);
	public Payment find(Integer paymentUid);
	public List<Payment> findAll();
}
