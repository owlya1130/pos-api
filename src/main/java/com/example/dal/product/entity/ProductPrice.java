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
@Table(name="product_prices")
public class ProductPrice {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_price_uid")
	private Integer priceUid;
	
	@Column(name="product_uid", nullable=false)
	private Integer productUid;
	
	@Column(name="level_uid", nullable=false)
	private Integer levelUid;
	
	@Column(name="price", nullable=false)
	private Integer price;
}
