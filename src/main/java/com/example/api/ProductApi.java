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
import com.example.bll.product.bo.ProductDetailBO;
import com.example.bll.store.StoreSvc;
import com.example.dal.product.entity.Product;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("product")
public class ProductApi {
	@Autowired
	private ProductSvc productSvc;
	@Autowired
	private StoreSvc storeSvc;
	
	@PostMapping
	ProductDetailBO save(@RequestBody ProductDetailBO productDetailBO) {
		return productSvc.save(productDetailBO, storeSvc.findAll());
	}
	
	@PutMapping
	ProductDetailBO update(@RequestBody ProductDetailBO productDetailBO) {
		return productSvc.update(productDetailBO);
	}
	
	@DeleteMapping("{product_uid}")
	void delete(@PathVariable(name="product_uid") Integer productUid) {
		productSvc.delete(productUid);
	}
	
	@GetMapping("{product_uid}")
	ProductDetailBO find(@PathVariable(name="product_uid") Integer productUid) {
		return productSvc.findByProductUid(productUid);
	}
	
	@GetMapping("barcode/{barcode}")
	Product findByBarcode(@PathVariable(name="barcode") String barcode) {
		return productSvc.findByBarcode(barcode);
	}
	
	@GetMapping("list")
	List<Product> findAll() {
		return productSvc.findAll();
	}
}
