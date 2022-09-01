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
@Table(name="cash_active_orders")
public class CashActiveOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cash_active_uid")
	private Integer cashActiveUid;
	
	@Column(name="store_uid", nullable=false)
	private Integer storeUid;
	
	@Column(name="action", nullable=false)
	private String action;
	
	@Column(name="cash", nullable=false)
	private Integer cash;
	
	@Column(name="create_datetime", nullable=false)
	private Date createDatetime = new Date();
	
	@Column(name="note", length=100, nullable=false)
	private String note;

}
