package com.example.dal.vender;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dal.vender.entity.Vender;

@Repository
public interface VenderDao extends JpaRepository<Vender, Integer> {
}
