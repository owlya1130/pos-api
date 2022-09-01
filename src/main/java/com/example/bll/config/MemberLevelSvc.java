package com.example.bll.config;

import java.util.List;

import com.example.dal.config.entity.MemberLevel;

public interface MemberLevelSvc {
	public MemberLevel save(MemberLevel memberLevel);
	public MemberLevel update(MemberLevel memberLevel);
	public void delete(Integer levelUid);
	public MemberLevel find(Integer levelUid);
	public List<MemberLevel> findAll();
}
