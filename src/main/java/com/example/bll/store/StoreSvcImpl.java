package com.example.bll.store;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bll.product.ProductQuantitySvc;
import com.example.dal.product.entity.Product;
import com.example.dal.store.StoreDao;
import com.example.dal.store.entity.Store;

@Service
public class StoreSvcImpl implements StoreSvc {
	@Autowired
	private StoreDao storeDao;
	
	@Autowired
	private ProductQuantitySvc productQuantitySvc;
	
	@Override
	@Transactional
	public Store save(Store store, List<Product> productEntitys) {
		Store storeEntity = storeDao.save(store);
		for(Product productEntity: productEntitys) {
			productQuantitySvc.setDefault(productEntity.getProductUid(), storeEntity.getStoreUid());
		}
		return storeEntity;
	}

	@Override
	public Store update(Store store) {
		return storeDao.save(store);
	}

	@Override
	public void delete(Integer storeUid) {
		storeDao.deleteById(storeUid);
	}

	@Override
	public List<Store> findAll() {
		return storeDao.findAll();
	}

	@Override
	public Store findByStoreUid(Integer storeUid) {
		return storeDao.findById(storeUid).get();
	}

}
