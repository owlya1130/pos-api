package com.example.dal.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dal.order.entity.StockinOrderDetail;

@Repository
public interface StockinOrderDetailDao extends JpaRepository<StockinOrderDetail, Integer> {
	public List<StockinOrderDetail> findByStockinUid(Integer stockinUid);
}
