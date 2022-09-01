package com.example.dal.config.entity;

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
@Table(name="config_product_catagorys")
public class ProductCatagory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="catagory_uid")
	private Integer catagoryUid;
	
	@Column(name="catagory_id", length=20, nullable=false, unique=true)
	private String catagoryId;
	
	@Column(name="name", length=20, nullable=false)
	private String name;
}
