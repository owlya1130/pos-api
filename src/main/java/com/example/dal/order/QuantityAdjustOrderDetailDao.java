package com.example.dal.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dal.order.entity.QuantityAdjustOrderDetail;

@Repository
public interface QuantityAdjustOrderDetailDao extends JpaRepository<QuantityAdjustOrderDetail, Integer> {
	public List<QuantityAdjustOrderDetail> findByQuantityAdjustUid(Integer quantityAdjustUid);

}
