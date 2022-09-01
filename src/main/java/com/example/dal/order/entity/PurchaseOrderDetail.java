package com.example.dal.order.entity;

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
@Table(name="purchase_order_details")
public class PurchaseOrderDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="purchase_detail_uid")
	private Integer purchaseDetailUid;
	
	@Column(name="purchase_uid", nullable=false)
	private Integer purchaseUid;
	
	@Column(name="product_name", length=20, nullable=false)
	private String productName;
	
	@Column(name="quantity", nullable=false)
	private Integer quantity;

}
