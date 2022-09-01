package com.example.dal.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dal.product.entity.ProductQuantity;

@Repository
public interface ProductQuantityDao extends JpaRepository<ProductQuantity, Integer> {
	public ProductQuantity findByProductUidAndStoreUid(Integer productUid, Integer storeUid);
}
