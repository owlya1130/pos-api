package com.example.dal.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="product_quantitys")
public class ProductQuantity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_quantity_uid")
	private Integer quantityUid;
	
	@Column(name="store_uid", nullable=false)
	private Integer storeUid;

	@Column(name="product_uid", nullable=false)
	private Integer productUid;
	
	@Column(name="quantity", nullable=false)
	private Integer quantity = 0;
	
	public ProductQuantity(Integer productUid, Integer storeUid) {
		this.productUid = productUid;
		this.storeUid = storeUid;
	}
	
	public void addQuantity(Integer diffQuantity) {
		quantity += diffQuantity;
	}
}
