package com.example.dal.product.entity;

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
@Table(name="product_barcodes")
public class ProductBarcode {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_barcode_uid")
	private Integer barcodeUid;
	
	@Column(name="product_uid", nullable=false)
	private Integer productUid;
	
	@Column(name="barcode", length=20, nullable=false)
	private String barcode;
	
	public ProductBarcode(Integer productUid, String barcode) {
		this.productUid = productUid;
		this.barcode = barcode;
	}
}
