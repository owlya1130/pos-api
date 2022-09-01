package com.example.bll.config;

import java.util.List;

import com.example.dal.config.entity.ProductCatagory;


public interface ProductCatagorySvc {
	public ProductCatagory save(ProductCatagory productCatagory);
	public ProductCatagory update(ProductCatagory productCatagory);
	public void delete(Integer catagoryUid);
	public ProductCatagory findByCatagoryUid(Integer catagoryUid);
	public List<ProductCatagory> findAll();
}
