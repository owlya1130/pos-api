package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bll.order.StockinOrderSvc;
import com.example.bll.order.bo.StockinOrderBO;
import com.example.dal.order.entity.StockinOrder;

@RestController
@RequestMapping("store/{store_uid}/stockin-order")
public class StockinOrderApi {
	@Autowired
	private StockinOrderSvc stockinOrderSvc;
	
	@GetMapping("list")
	List<StockinOrder> findAll() {
		return stockinOrderSvc.findAll();
	}

	@GetMapping("{stockin_uid}")
	StockinOrderBO findByOrderUid(@PathVariable("stockin_uid") Integer stockinUid) {
		return stockinOrderSvc.findByOrderUid(stockinUid);
	}

	@PostMapping
	StockinOrderBO save(@RequestBody StockinOrderBO stockinOrderBO) {
		return stockinOrderSvc.save(stockinOrderBO);
	}
}
