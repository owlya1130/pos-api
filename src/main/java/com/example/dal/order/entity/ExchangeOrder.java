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
@Table(name="exchange_orders")
public class ExchangeOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="exchange_uid")
	private Integer exchangeUid;
	
	@Column(name="store_uid", nullable=false)
	private Integer storeUid;
	
	@Column(name="vender_uid", nullable=false)
	private Integer venderVid;
	
	@Column(name="create_datetime", nullable=false)
	private Date createDatetime = new Date();
	
	@Column(name="vender_took", nullable=false)
	private boolean venderTook = false;
	
	@Column(name="vender_took_datetime")
	private Date venderTookDatetime;
	
	@Column(name="closed", nullable=false)
	private boolean closed = false;
	
	@Column(name="note", length=100)
	private String note;
	
	public void venderTook() {
		venderTook = true;
		venderTookDatetime = new Date();
	}

}
