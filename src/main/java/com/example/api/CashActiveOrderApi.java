package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bll.order.CashActiveOrderSvc;
import com.example.dal.order.entity.CashActiveOrder;

@RestController
@RequestMapping("store/{store_uid}/cash-active-order")
public class CashActiveOrderApi {
	@Autowired
	private CashActiveOrderSvc cashActiveOrderSvc;
	
	@GetMapping("list")
	List<CashActiveOrder> findAll() {
		return cashActiveOrderSvc.findAll();
	}

	@PostMapping
	CashActiveOrder save(
			@PathVariable(name="store_uid") Integer storeUid, 
			@RequestBody CashActiveOrder cashActiveOrder) {
		return cashActiveOrderSvc.save(storeUid, cashActiveOrder);
	}
}
