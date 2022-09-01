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
@Table(name="destory_orders")
public class DestoryOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="destory_uid")
	private Integer destoryUid;
	
	@Column(name="store_uid", nullable=false)
	private Integer storeUid;
	
	@Column(name="create_datetime", nullable=false)
	private Date createDatetime = new Date();
	
	@Column(name="is_approved")
	private boolean isApproved;
	
	@Column(name="note", length=100)
	private String note;

}
