package com.example.bll.config;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dal.config.PaymentDao;
import com.example.dal.config.entity.Payment;

@Service
public class PaymentSvcImpl implements PaymentSvc {
	@Autowired
	private PaymentDao paymentDao;
	
	@Override
	@Transactional
	public Payment save(Payment payment) {
		return paymentDao.save(payment);
	}

	@Override
	@Transactional
	public Payment update(Payment payment) {
		boolean isEmpty = paymentDao.findById(payment.getPaymentUid()).isEmpty();
		if(isEmpty) {
			throw new RuntimeException("payment is not exist");
		}
		return paymentDao.save(payment);
	}

	@Override
	@Transactional
	public void delete(Integer paymentUid) {
		paymentDao.deleteById(paymentUid);
	}

	@Override
	public List<Payment> findAll() {
		return paymentDao.findAll();
	}

	@Override
	public Payment find(Integer paymentUid) {
		return paymentDao.findById(paymentUid).get();
	}

}
