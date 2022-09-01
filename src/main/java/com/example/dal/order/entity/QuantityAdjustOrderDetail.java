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
@Table(name="quantity_adjust_order_details")
public class QuantityAdjustOrderDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="quantity_adjust_detail_uid")
	private Integer quantityAdjustDetailUid;
	
	@Column(name="quantity_adjust_uid", nullable=false)
	private Integer quantityAdjustUid;
	
	@Column(name="product_uid", nullable=false)
	private Integer productUid;
	
	@Column(name="system_quantity", nullable=false)
	private Integer systemQuantity;
	
	@Column(name="actual_quantity", nullable=false)
	private Integer actualQuantity;
	
	@Column(name="note", length=100)
	private String note;

}
