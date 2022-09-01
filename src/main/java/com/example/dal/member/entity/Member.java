package com.example.dal.member.entity;

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
@Table(name="members")
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="member_uid")
	private Integer memberUid;
	
	@Column(name="member_id", length=20, nullable=false, unique=true)
	private String memberId;
	
	@Column(name="name", length=20, nullable=false)
	private String name;
	
	@Column(name="level_uid", nullable=false)
	private Integer levelUid;
	
	@Column(name="mobile_no", length=10, nullable=false)
	private String mobileNo;
	
	@Column(name="email", length=50)
	private String email;
	
	@Column(name="address", length=50)
	private String address;
	
	@Column(name="stored_cash", nullable=false)
	private Integer storedCash = 0;
	
	@Column(name="member_point", nullable=false)
	private Integer memberPoint = 0;
	
	@Column(name="note", length=100)
	private String note;
	
	public void addMemberPoint(Integer points) {
		memberPoint += points;
	}
	
	public void addStoredCash(Integer cash) {
		storedCash += cash;
	}
}
