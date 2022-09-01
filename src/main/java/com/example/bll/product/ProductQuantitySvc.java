package com.example.bll.product;

import com.example.dal.product.entity.ProductQuantity;

public interface ProductQuantitySvc {
	public void setDefault(Integer productUid, Integer storeUid);
	public ProductQuantity findByProductUidAndStoreUid(Integer productUid, Integer storeUid);
}
