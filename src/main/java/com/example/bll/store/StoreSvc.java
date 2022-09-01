package com.example.bll.store;

import java.util.List;

import com.example.dal.product.entity.Product;
import com.example.dal.store.entity.Store;

public interface StoreSvc {
	public Store save(Store store, List<Product> productEntitys);
	public Store update(Store store);
	public void delete(Integer storeUid);
	public List<Store> findAll();
	public Store findByStoreUid(Integer storeUid);
}
