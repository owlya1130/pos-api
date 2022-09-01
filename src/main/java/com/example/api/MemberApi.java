package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bll.member.MemberSvc;
import com.example.dal.member.entity.Member;

@RestController
@RequestMapping("member")
public class MemberApi {
	@Autowired
	private MemberSvc memberSvc;
	
	@PostMapping
	Member save(@RequestBody Member member) {
		return memberSvc.save(member);
	}
	
	@PutMapping
	Member update(@RequestBody Member member) {
		return memberSvc.update(member);
	}
	
	@DeleteMapping("{member_uid}")
	void delete(@PathVariable(name="member_uid") Integer memberUid) {
		memberSvc.delete(memberUid);
	}
	
	@GetMapping("{member_uid}")
	Member find(@PathVariable(name="member_uid") Integer memberUid) {
		return memberSvc.findByMemberUid(memberUid);
	}
	
	@GetMapping("list")
	List<Member> findAll() {
		return memberSvc.findAll();
	}
}
