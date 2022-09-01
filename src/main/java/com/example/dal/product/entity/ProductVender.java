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
@Table(name="product_venders")
public class ProductVender {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_vender_uid")
	private Integer prodVenderUid;
	
	@Column(name="product_uid", nullable=false)
	private Integer productUid;
	
	@Column(name="vender_uid", nullable=false)
	private Integer venderUid;
}
