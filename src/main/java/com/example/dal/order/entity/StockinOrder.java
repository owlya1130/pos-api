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
@Table(name="stockin_orders")
public class StockinOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stockin_uid")
	private Integer stockinUid;
	
	@Column(name="store_uid", nullable=false)
	private Integer storeUid;
	
	@Column(name="vender_uid", nullable=false)
	private Integer venderUid;
	
	@Column(name="create_datetime", nullable=false)
	private Date createDatetime = new Date();

}
