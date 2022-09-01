package com.example.bll.config;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dal.config.ProductCatagoryDao;
import com.example.dal.config.entity.ProductCatagory;

@Service
public class ProductCatagorySvcImpl implements ProductCatagorySvc {
	@Autowired
	private ProductCatagoryDao productCatagoryDao;
	
	@Override
	@Transactional
	public ProductCatagory save(ProductCatagory productCatagory) {
		return productCatagoryDao.save(productCatagory);
	}

	@Override
	public ProductCatagory update(ProductCatagory productCatagory) {
		return productCatagoryDao.save(productCatagory);
	}

	@Override
	public void delete(Integer catagoryUid) {
		productCatagoryDao.deleteById(catagoryUid);
	}

	@Override
	public ProductCatagory findByCatagoryUid(Integer catagoryUid) {
		return productCatagoryDao.findById(catagoryUid).get();
	}

	@Override
	public List<ProductCatagory> findAll() {
		return productCatagoryDao.findAll();
	}

}
