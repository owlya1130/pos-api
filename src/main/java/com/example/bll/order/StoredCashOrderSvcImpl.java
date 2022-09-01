package com.example.bll.order;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dal.order.StoredCashOrderDao;
import com.example.dal.order.entity.StoredCashOrder;

@Service
public class StoredCashOrderSvcImpl implements StoredCashOrderSvc {
	@Autowired
	private StoredCashOrderDao storedCashOrderDao;

	@Override
	@Transactional
	public StoredCashOrder save(StoredCashOrder storedCashOrder) {
		return storedCashOrderDao.save(storedCashOrder);
	}

	@Override
	public List<StoredCashOrder> findAll() {
		return storedCashOrderDao.findAll();
	}

}
