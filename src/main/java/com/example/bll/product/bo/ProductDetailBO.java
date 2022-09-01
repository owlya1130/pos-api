package com.example.bll.product.bo;

import java.util.List;

import com.example.dal.product.entity.Product;
import com.example.dal.product.entity.ProductBarcode;
import com.example.dal.product.entity.ProductCombination;
import com.example.dal.product.entity.ProductPrice;
import com.example.dal.product.entity.ProductVender;

import lombok.Value;

@Value
public class ProductDetailBO {
	private final Product product;
	private final List<ProductPrice> prices;
	private final List<ProductBarcode> barcodes;
	private final List<ProductVender> venders;
	private final List<ProductCombination> combinations;
}
