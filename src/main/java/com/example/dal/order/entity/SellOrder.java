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
@Table(name="sell_orders")
public class SellOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sell_uid")
	private Integer sellUid;
	
	@Column(name="store_uid", nullable=false)
	private Integer storeUid;
	
	@Column(name="member_uid", nullable=false)
	private Integer memberUid;
	
	@Column(name="create_datetime", nullable=false)
	private Date create_datetime = new Date();
	
	@Column(name="total_price", nullable=false)
	private Integer totalPrice;
	
	@Column(name="closed", nullable=false)
	private boolean closed = false;
	
	@Column(name="is_invalid", nullable=false)
	private boolean isInvalid = false;
	
	@Column(name="invalid_datetime")
	private Date invalidDatetime;
	
	public void invalidOrder() {
		isInvalid = true;
		invalidDatetime = new Date();
	}

}
