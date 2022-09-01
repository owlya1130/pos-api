package com.example.dal.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="products")
@Where(clause="is_deleted=false")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_uid")
	private Integer productUid;
	
	@Column(name="product_id", length=20, nullable=false, unique=true)
	private String productId;
	
	@Column(name="name", length=20, nullable=false)
	private String name;
	
	@Column(name="catagory_uid", nullable=false)
	private Integer catagoryUid;
	
	@Column(name="is_service", nullable=false)
	private boolean isService = false;
	
	@Column(name="allow_sell_insufficient", nullable=false)
	private boolean allowSellInsufficient = true;
	
	@Column(name="is_conbination", nullable=false)
	private boolean isConbination = false;
	
	@Column(name="is_invalid", nullable=false)
	private boolean isInvalid = false;
	
	@Column(name="is_deleted", nullable=false)
	private boolean isDeleted = false;
	
	@Column(name="note", length=100)
	private String note;
}
