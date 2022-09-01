package com.example.bll.config;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dal.config.MemberLevelDao;
import com.example.dal.config.entity.MemberLevel;

@Service
public class MemberLevelSvcImpl implements MemberLevelSvc {
	@Autowired
	private MemberLevelDao memberLevelDao;
	
	@Override
	@Transactional
	public MemberLevel save(MemberLevel memberLevel) {
		return memberLevelDao.save(memberLevel);
	}

	@Override
	public MemberLevel update(MemberLevel memberLevel) {
		return memberLevelDao.save(memberLevel);
	}

	@Override
	public void delete(Integer levelUid) {
		memberLevelDao.deleteById(levelUid);
	}

	@Override
	public List<MemberLevel> findAll() {
		return memberLevelDao.findAll();
	}

	@Override
	public MemberLevel find(Integer levelUid) {
		return memberLevelDao.findById(levelUid).get();
	}

}
