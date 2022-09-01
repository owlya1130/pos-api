package com.example.dal.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dal.product.entity.ProductCombination;

@Repository
public interface ProductCombinationDao extends JpaRepository<ProductCombination, Integer> {
	public List<ProductCombination> findByProductUid(Integer productUid);
}
