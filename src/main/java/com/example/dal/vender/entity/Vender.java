package com.example.dal.vender.entity;

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
@Table(name="venders")
public class Vender {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vender_uid")
	private Integer venderUid;
	
	@Column(name="vender_id", length=20, nullable=false, unique=true)
	private String venderId;
	
	@Column(name="name", length=20, nullable=false)
	private String name;
}
