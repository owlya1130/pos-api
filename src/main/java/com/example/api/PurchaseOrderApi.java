package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bll.order.PurchaseOrderSvc;
import com.example.bll.order.bo.PurchaseOrderBO;
import com.example.dal.order.entity.PurchaseOrder;

@RestController
@RequestMapping("vender/{vender_uid}/purchase-order")
public class PurchaseOrderApi {
	@Autowired
	private PurchaseOrderSvc purchaseOrderSvc;
	
	@GetMapping("list")
	List<PurchaseOrder> findAll() {
		return purchaseOrderSvc.findAll();
	}

	@GetMapping("{purchase_uid}")
	PurchaseOrderBO findByOrderUid(@PathVariable("{purchase_uid}") Integer purchaseUid) {
		return purchaseOrderSvc.findByOrderUid(purchaseUid);
	}

	@PostMapping
	PurchaseOrderBO save(@RequestBody PurchaseOrderBO purchaseOrderBO) {
		return purchaseOrderSvc.save(purchaseOrderBO);
	}
}
