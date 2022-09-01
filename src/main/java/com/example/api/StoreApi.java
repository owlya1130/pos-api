package com.example.api;

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

import com.example.bll.product.ProductSvc;
import com.example.bll.store.StoreSvc;
import com.example.dal.store.entity.Store;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("store")
public class StoreApi {
	@Autowired
	private StoreSvc storeSvc;
	@Autowired
	private ProductSvc productSvc;
	
	@PostMapping
	Store save(@RequestBody Store store) {
		return storeSvc.save(store, productSvc.findAll());
	}
	
	@PutMapping
	Store update(@RequestBody Store store) {
		return storeSvc.update(store);
	}
	
	@DeleteMapping("{store_uid}")
	void delete(@PathVariable(name="store_uid") Integer storeUid) {
		storeSvc.delete(storeUid);
	}
	
	@GetMapping("{store_uid}")
	Store find(@PathVariable(name="store_uid") Integer storeUid) {
		return storeSvc.findByStoreUid(storeUid);
	}
	
	@GetMapping("list")
	List<Store> findAll() {
		return storeSvc.findAll();
	}
}
