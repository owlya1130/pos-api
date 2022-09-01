package com.example.dal.order.entity;

import java.util.Date;

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
@Table(name="exhcange_order_receipts")
public class ExchangeOrderReceipt {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="exchange_receipt_uid")
	private Integer exchangeReceiptUid;
	
	@Column(name="exchange_uid", nullable=false)
	private Integer exchangeUid;
	
	@Column(name="product_uid", nullable=false)
	private Integer productUid;
	
	@Column(name="quantity", nullable=false)
	private Integer quantity;
	
	@Column(name="create_datetime", nullable=false)
	private Date createDatetime = new Date();

}
