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
@Table(name="delivery_orders")
public class DeliveryOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="delivery_uid")
	private Integer deliveryUid;
	
	@Column(name="src_store_uid", nullable=false)
	private Integer srcStoreUid;
	
	@Column(name="dst_store_uid", nullable=false)
	private Integer dstStoreUid;
	
	@Column(name="create_datetime", nullable=false)
	private Date createDatetime = new Date();
	
	@Column(name="is_packed")
	private boolean isPacked;
	
	@Column(name="pack_datetie")
	private Date packDatetie;
	
	@Column(name="closed")
	private boolean closed;
	
	@Column(name="close_datetime")
	private Date closeDatetime;
	
	@Column(name="note", length=100)
	private String note;
	
	public void pack() {
		isPacked = true;
		packDatetie = new Date();
	}
	
	public void close() {
		closed = true;
		closeDatetime = new Date();
	}

}
