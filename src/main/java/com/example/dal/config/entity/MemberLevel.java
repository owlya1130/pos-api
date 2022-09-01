package com.example.dal.config.entity;

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
@Table(name="config_member_levels")
public class MemberLevel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="level_uid")
	private Integer levelUid;
	
	@Column(name="level_id", length=20, nullable=false, unique=true)
	private String levelId;
	
	@Column(name="name", length=20, nullable=false)
	private String name;
	
	@Column(name="is_default", nullable=false)
	private boolean isDefault = false;
}
