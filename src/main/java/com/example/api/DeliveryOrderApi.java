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

import com.example.bll.order.DeliveryOrderSvc;
import com.example.bll.order.bo.DeliveryOrderBO;
import com.example.dal.order.entity.DeliveryOrder;

@RestController
@RequestMapping("product/delivery-order")
public class DeliveryOrderApi {
	@Autowired
	private DeliveryOrderSvc deliveryOrderSvc;
	
	@GetMapping("list")
	List<DeliveryOrder> findAll() {
		return deliveryOrderSvc.findAll();
	}

	@GetMapping("{delivery_uid}")
	DeliveryOrderBO findByOrderUid(@PathVariable("{delivery_uid}") Integer deliveryUid) {
		return deliveryOrderSvc.findByOrderUid(deliveryUid);
	}

	@PostMapping
	DeliveryOrderBO save(@RequestBody DeliveryOrderBO deliveryOrderBO) {
		return deliveryOrderSvc.save(deliveryOrderBO);
	}

	@PostMapping("src-store/{store_uid}")
	DeliveryOrderBO pack(@RequestBody DeliveryOrderBO deliveryOrderBO) {
		return deliveryOrderSvc.pack(deliveryOrderBO);
	}

	@PutMapping("dst-store/{store_uid}")
	DeliveryOrderBO receive(@RequestBody DeliveryOrderBO deliveryOrderBO) {
		return deliveryOrderSvc.receive(deliveryOrderBO);
	}

}
