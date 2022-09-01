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
@Table(name="exchange_order_details")
public class ExchangeOrderDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="exchange_detail_uid")
	private Integer exchangeDetailUid;
	
	@Column(name="exchange_uid", nullable=false)
	private Integer exchangeUid;
	
	@Column(name="product_uid", nullable=false)
	private Integer productUid;
	
	@Column(name="exchange_quantity", nullable=false)
	private Integer exchangeQuantity;
	
	@Column(name="receive_quantity", nullable=false)
	private Integer receiveQuantity = 0;
	
	@Column(name="note", length=100)
	private String note;
	
	public void receive(Integer quantity) {
		receiveQuantity += quantity;
	}

}
