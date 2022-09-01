package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bll.order.SellOrderSvc;
import com.example.bll.order.bo.SellOrderBO;
import com.example.bll.order.bo.SellOrderInvalidBO;
import com.example.dal.order.entity.SellOrder;
import com.example.dal.order.entity.SellOrderPayment;

@RestController
@RequestMapping("store/{store_uid}/sell-order")
public class SellOrderApi {
	@Autowired
	private SellOrderSvc sellOrderSvc;
	
	@GetMapping("list")
	List<SellOrder> findAll() {
		return sellOrderSvc.findAll();
	}

	@GetMapping("{sell_uid}")
	SellOrderBO findByOrderUid(@PathVariable("{sell_uid}") Integer sellUid) {
		return sellOrderSvc.findByOrderUid(sellUid);
	}

	@PostMapping
	SellOrderBO save(@RequestBody SellOrderBO sellOrderBO) {
		return sellOrderSvc.save(sellOrderBO);
	}

	@PostMapping("{sell_uid}/payment")
	SellOrderBO addPayment(
			@PathVariable("{sell_uid}") Integer sellUid,
			@RequestBody SellOrderPayment sellOrderPayment) {
		return sellOrderSvc.addPayment(sellUid, sellOrderPayment);
	}

	@PutMapping("{sell_uid}/invalid")
	SellOrderInvalidBO audit(@PathVariable("{sell_uid}") Integer sellUid) {
		return sellOrderSvc.invalidOrder(sellUid);
	}

}
