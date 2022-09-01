package com.example.dal.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dal.member.entity.Member;

@Repository
public interface MemberDao extends JpaRepository<Member, Integer> {
}
