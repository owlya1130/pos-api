package com.example.dal.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dal.order.entity.DeliveryOrderDetail;

@Repository
public interface DeliveryOrderDetailDao extends JpaRepository<DeliveryOrderDetail, Integer> {
	public List<DeliveryOrderDetail> findByDeliveryUid(Integer deliveryUid);
}
