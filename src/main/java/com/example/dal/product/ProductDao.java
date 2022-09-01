package com.example.dal.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dal.product.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
}
