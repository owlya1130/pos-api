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
@Table(name="quantity_adjust_orders")
public class QuantityAdjustOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="quantity_adjust_uid")
	private Integer quantityAdjustUid;
	
	@Column(name="store_uid", nullable=false)
	private Integer storeUid;
	
	@Column(name="create_datetime", nullable=false)
	private Date createDatetime = new Date();
	
	@Column(name="is_approved")
	private boolean isApproved;
	
	@Column(name="approve_datetime")
	private Date isApproveDatetime;
	
	@Column(name="note", length=100)
	private String note;
	
	public void approve(boolean isApprove) {
		this.isApproved = isApprove;
		isApproveDatetime = new Date();
	}

}
