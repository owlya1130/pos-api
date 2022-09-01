package com.example.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bll.order.QuantityAdjustOrderSvc;
import com.example.bll.order.bo.QuantityAdjustOrderBO;
import com.example.dal.order.entity.QuantityAdjustOrder;

@RestController
@RequestMapping("store/{store_uid}/quantity-adjust-order")
public class QuantityAdjustOrderApi {
	@Autowired
	private QuantityAdjustOrderSvc quantityAdjustOrderSvc;
	
	@GetMapping("list")
	List<QuantityAdjustOrder> findAll() {
		return quantityAdjustOrderSvc.findAll();
	}

	@GetMapping("{quantity_adjust_uid}")
	QuantityAdjustOrderBO findByOrderUid(@PathVariable("{quantity_adjust_uid}") Integer quantityAdjustUid) {
		return quantityAdjustOrderSvc.findByOrderUid(quantityAdjustUid);
	}

	@PostMapping
	QuantityAdjustOrderBO save(@RequestBody QuantityAdjustOrderBO quantityAdjustOrderBO) {
		return quantityAdjustOrderSvc.save(quantityAdjustOrderBO);
	}

	@PutMapping("{quantity_adjust_uid}/audit")
	QuantityAdjustOrderBO audit(
			@PathVariable("{quantity_adjust_uid}") Integer quantityAdjustUid,
			@RequestBody Map<String, Boolean> audit) {
		return quantityAdjustOrderSvc.audit(quantityAdjustUid, audit.get("approve"));
	}

}
