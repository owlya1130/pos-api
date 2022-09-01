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
@Table(name="sell_order_payments")
public class SellOrderPayment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sell_payment_uid")
	private Integer sellPaymentUid;
	
	@Column(name="sell_uid", nullable=false)
	private Integer sellUid;
	
	@Column(name="payment_uid", nullable=false)
	private Integer paymentUid;
	
	@Column(name="price", nullable=false)
	private Integer price;
	
	@Column(name="create_datetime", nullable=false)
	private Date create_datetime = new Date();

}
