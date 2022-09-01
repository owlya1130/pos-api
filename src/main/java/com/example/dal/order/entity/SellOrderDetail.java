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
@Table(name="sell_order_details")
public class SellOrderDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sell_detail_uid")
	private Integer sellDetailUid;
	
	@Column(name="sell_uid", nullable=false)
	private Integer sellUid;
	
	@Column(name="product_uid", nullable=false)
	private Integer productUid;
	
	@Column(name="quantity", nullable=false)
	private Integer quantity;
	
	@Column(name="level", length=20, nullable=false)
	private String level;
	
	@Column(name="level_price", nullable=false)
	private Integer levelPrice;

}
