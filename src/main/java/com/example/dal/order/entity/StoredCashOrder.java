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
@Table(name="stored_cash_orders")
public class StoredCashOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stored_cash_uid")
	private Integer storedCashUid;
	
	@Column(name="member_uid", nullable=false)
	private Integer memberUid;
	
	@Column(name="current_cash", nullable=false)
	private Integer currentCash;
	
	@Column(name="store_cash", nullable=false)
	private Integer storeCash;
	
	@Column(name="create_datetime", nullable=false)
	private Date createDatetime = new Date();

}
