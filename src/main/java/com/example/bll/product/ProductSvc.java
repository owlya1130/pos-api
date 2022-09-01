package com.example.bll.product;

import java.util.List;

import com.example.bll.product.bo.ProductDetailBO;
import com.example.dal.product.entity.Product;
import com.example.dal.store.entity.Store;

public interface ProductSvc {
	public ProductDetailBO save(ProductDetailBO productDetailBO, List<Store> storeEntitys);
	public ProductDetailBO update(ProductDetailBO product);
	public void delete(Integer productUid);
	public List<Product> findAll();
	public ProductDetailBO findByProductUid(Integer productUid);
	public Product findByBarcode(String barcode);
}
