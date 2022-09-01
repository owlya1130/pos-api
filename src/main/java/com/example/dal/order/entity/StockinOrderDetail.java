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
@Table(name="stockin_order_details")
public class StockinOrderDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stockin_detail_uid")
	private Integer stockinDetailUid;
	
	@Column(name="stockin_uid", nullable=false)
	private Integer stockinUid;
	
	@Column(name="product_uid", nullable=false)
	private Integer productUid;
	
	@Column(name="total_quantity", nullable=false)
	private Integer totalQuantity;
	
	@Column(name="total_price", nullable=false)
	private Integer totalPrice;
	
	@Column(name="expired_date", nullable=false)
	private Date expiredDate;

}
