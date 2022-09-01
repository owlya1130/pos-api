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
@Table(name="product_combinations")
public class ProductCombination {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_combination_uid")
	private Integer combinationUid;
	
	@Column(name="product_uid", nullable=false)
	private Integer productUid;
	
	@Column(name="content_product_uid", nullable=false)
	private Integer contentProductUid;
	
	@Column(name="quantity", nullable=false)
	private Integer quantity;
}
