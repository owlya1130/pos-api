package com.example.bll.member;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dal.member.MemberDao;
import com.example.dal.member.entity.Member;

@Service
public class MemberSvcImpl implements MemberSvc {
	@Autowired
	private MemberDao memberDao;
	
	@Override
	@Transactional
	public Member save(Member member) {
		return memberDao.save(member);
	}

	@Override
	public Member update(Member member) {
		return memberDao.save(member);
	}

	@Override
	public void delete(Integer memberUid) {
		memberDao.deleteById(memberUid);
	}

	@Override
	public List<Member> findAll() {
		return memberDao.findAll();
	}

	@Override
	public Member findByMemberUid(Integer memberUid) {
		return memberDao.findById(memberUid).get();
	}

}
