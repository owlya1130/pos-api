package com.example.dal.store.entity;

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
@Table(name="stores")
public class Store {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="store_uid")
	private Integer storeUid;
	
	@Column(name="store_id", length=20, nullable=false, unique=true)
	private String storeId;
	
	@Column(name="name", length=20, nullable=false)
	private String name;
	
	@Column(name="cashbox", nullable=false)
	private Integer cashbox = 0;
	
	public void addCash(Integer cash) {
		cashbox += cash;
	}
}
