package com.example.dal.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dal.order.entity.DestoryOrderDetail;

@Repository
public interface DestoryOrderDetailDao extends JpaRepository<DestoryOrderDetail, Integer> {
	public List<DestoryOrderDetail> findByDestoryUid(Integer destoryUid);
}
