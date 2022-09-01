package com.example.api.config;

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

import com.example.bll.config.ProductCatagorySvc;
import com.example.dal.config.entity.ProductCatagory;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("product-catagory")
public class ProductCatagoryApi {
	@Autowired
	private ProductCatagorySvc productCatagorySvc;

	@PostMapping
	ProductCatagory save(@RequestBody ProductCatagory productCatagory) {
		return productCatagorySvc.save(productCatagory);
	}

	@PutMapping
	ProductCatagory update(@RequestBody ProductCatagory productCatagory) {
		return productCatagorySvc.update(productCatagory);
	}

	@DeleteMapping("{catagory_uid}")
	void delete(@PathVariable(name = "catagory_uid") Integer catagoryUid) {
		productCatagorySvc.delete(catagoryUid);
	}

	@GetMapping("{catagory_uid}")
	ProductCatagory find(@PathVariable(name = "catagory_uid") Integer catagoryUid) {
		return productCatagorySvc.findByCatagoryUid(catagoryUid);
	}

	@GetMapping("list")
	List<ProductCatagory> findAll() {
		return productCatagorySvc.findAll();
	}
}
