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
@Table(name="config_payments")
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="payment_uid")
	private Integer paymentUid;
	
	@Column(name="payment_id", length=20, nullable=false, unique=true)
	private String paymentId;
	
	@Column(name="name", length=20, nullable=false)
	private String name;
	
	@Column(name="is_default", nullable=false)
	private boolean isDefault = false;
}
