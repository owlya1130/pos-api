package com.example.bll.product;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dal.product.ProductQuantityDao;
import com.example.dal.product.entity.ProductQuantity;

@Service
public class ProductQuantitySvcImpl implements ProductQuantitySvc {
	@Autowired
	private ProductQuantityDao productQuantityDao;

	@Override
	@Transactional
	public void setDefault(Integer productUid, Integer storeUid) {
		productQuantityDao.save(new ProductQuantity(productUid, storeUid));
	}

	@Override
	public ProductQuantity findByProductUidAndStoreUid(Integer productUid, Integer storeUid) {
		return productQuantityDao.findByProductUidAndStoreUid(productUid, storeUid);
	}
}
