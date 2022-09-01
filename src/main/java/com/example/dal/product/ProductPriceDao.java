package com.example.dal.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dal.product.entity.ProductPrice;

@Repository
public interface ProductPriceDao extends JpaRepository<ProductPrice, Integer> {
	public List<ProductPrice> findByProductUid(Integer productUid);
}
