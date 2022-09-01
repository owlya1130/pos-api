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
@Table(name="delivery_order_details")
public class DeliveryOrderDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="delivery_detail_uid")
	private Integer deliveryDetailUid;
	
	@Column(name="delivery_uid", nullable=false)
	private Integer deliveryUid;
	
	@Column(name="product_uid", nullable=false)
	private Integer productUid;
	
	@Column(name="delivery_quantity", nullable=false)
	private Integer deliveryQuantity;
	
	@Column(name="receive_quantity", nullable=false)
	private Integer receiveQuantity;
}
