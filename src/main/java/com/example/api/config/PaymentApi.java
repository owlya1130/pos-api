package com.example.api.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bll.config.PaymentSvc;
import com.example.dal.config.entity.Payment;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("payment")
public class PaymentApi {
	@Autowired
	private PaymentSvc paymentSvc;
	
	@PostMapping
	Payment save(@RequestBody Payment payment) {
		return paymentSvc.save(payment);
	}
	
	@PutMapping
	Payment update(@RequestBody Payment payment) {
		return paymentSvc.update(payment);
	}
	
	@DeleteMapping("{payment_uid}")
	void delete(@PathVariable(name="payment_uid") Integer paymentUid) {
		paymentSvc.delete(paymentUid);
	}

	@GetMapping("{payment_uid}")
	Payment find(@PathVariable(name = "payment_uid") Integer paymentUid) {
		return paymentSvc.find(paymentUid);
	}
	
	@GetMapping("list")
	List<Payment> findAll() {
		return paymentSvc.findAll();
	}
}
