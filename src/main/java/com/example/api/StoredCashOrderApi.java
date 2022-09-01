package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bll.order.StoredCashOrderSvc;
import com.example.dal.order.entity.StoredCashOrder;

@RestController
@RequestMapping("member/{member_uid}/stored-cash-order")
public class StoredCashOrderApi {
	@Autowired
	private StoredCashOrderSvc storedCashOrderSvc;
	
	@GetMapping("list")
	List<StoredCashOrder> findAll() {
		return storedCashOrderSvc.findAll();
	}

	@PostMapping
	StoredCashOrder save(@RequestBody StoredCashOrder storedCashOrder) {
		return storedCashOrderSvc.save(storedCashOrder);
	}
}
