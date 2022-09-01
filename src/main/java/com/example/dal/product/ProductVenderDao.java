package com.example.dal.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dal.product.entity.ProductVender;

@Repository
public interface ProductVenderDao extends JpaRepository<ProductVender, Integer> {
	public List<ProductVender> findByProductUid(Integer productUid);
}
