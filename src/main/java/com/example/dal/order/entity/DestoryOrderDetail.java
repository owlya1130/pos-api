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
@Table(name="destory_order_details")
public class DestoryOrderDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="destory_detail_uid")
	private Integer destory_detail_uid;
	
	@Column(name="destory_uid", nullable=false)
	private Integer destoryUid;
	
	@Column(name="product_uid", nullable=false)
	private Integer productUid;
	
	@Column(name="quantity", nullable=false)
	private Integer quantity;
	
	@Column(name="note", length=100)
	private String note;

}
