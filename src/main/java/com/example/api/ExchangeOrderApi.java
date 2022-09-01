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

import com.example.bll.order.ExchangeOrderSvc;
import com.example.bll.order.bo.ExchangeOrderBO;
import com.example.dal.order.entity.ExchangeOrder;
import com.example.dal.order.entity.ExchangeOrderReceipt;

@RestController
@RequestMapping("store/{store_uid}/exchange-order")
public class ExchangeOrderApi {
	@Autowired
	private ExchangeOrderSvc exchangeOrderSvc;
	
	@GetMapping("list")
	List<ExchangeOrder> findAll() {
		return exchangeOrderSvc.findAll();
	}

	@GetMapping("{exchange_uid}")
	ExchangeOrderBO findByOrderUid(@PathVariable("{exchange_uid}") Integer exchangeUid) {
		return exchangeOrderSvc.findByOrderUid(exchangeUid);
	}

	@PostMapping
	ExchangeOrderBO save(@RequestBody ExchangeOrderBO exchangeOrderBO) {
		return exchangeOrderSvc.save(exchangeOrderBO);
	}

	@PutMapping("{exchange_uid}/vender-pickup")
	ExchangeOrderBO audit(@PathVariable("{exchange_uid}") Integer exchangeUid) {
		return exchangeOrderSvc.venderPickup(exchangeUid);
	}

	@PostMapping("{exchange_uid}/products-receipt")
	ExchangeOrderBO save(
			@PathVariable("{exchange_uid}") Integer exchangeUid,
			@RequestBody List<ExchangeOrderReceipt> receipts) {
		return exchangeOrderSvc.saveProductsReceipt(exchangeUid, receipts);
	}

}
