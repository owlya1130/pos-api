package com.example.dal.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dal.product.entity.ProductBarcode;

@Repository
public interface ProductBarcodeDao extends JpaRepository<ProductBarcode, Integer> {
	public List<ProductBarcode> findByProductUid(Integer productUid);
	public ProductBarcode findByBarcode(String barcode);
}
