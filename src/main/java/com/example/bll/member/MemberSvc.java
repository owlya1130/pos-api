package com.example.bll.member;

import java.util.List;

import com.example.dal.member.entity.Member;

public interface MemberSvc {
	public Member save(Member member);
	public Member update(Member member);
	public void delete(Integer memberUid);
//	public Member findByMemberId(String memberId);
	public List<Member> findAll();
	public Member findByMemberUid(Integer memberUid);
}
