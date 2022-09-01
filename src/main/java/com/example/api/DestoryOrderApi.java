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

import com.example.bll.order.DestoryOrderSvc;
import com.example.bll.order.bo.DestoryOrderBO;
import com.example.dal.order.entity.DestoryOrder;

@RestController
@RequestMapping("store/{store_uid}/product/destory-order")
public class DestoryOrderApi {
	@Autowired
	private DestoryOrderSvc destoryOrderSvc;
	
	@GetMapping("list")
	List<DestoryOrder> findAll() {
		return destoryOrderSvc.findAll();
	}

	@GetMapping("{destory_uid}")
	DestoryOrderBO findByOrderUid(@PathVariable("{destory_uid}") Integer destoryUid) {
		return destoryOrderSvc.findByOrderUid(destoryUid);
	}

	@PostMapping
	DestoryOrderBO save(@RequestBody DestoryOrderBO destoryOrderBO) {
		return destoryOrderSvc.save(destoryOrderBO);
	}

	@PutMapping("{destory_uid}/audit")
	DestoryOrderBO audit(
			@PathVariable("{destory_uid}") Integer destoryUid,
			@RequestBody Map<String, Boolean> audit) {
		return destoryOrderSvc.audit(destoryUid, audit.get("approve"));
	}

}
