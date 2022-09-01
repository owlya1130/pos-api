package com.example.bll.order;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bll.store.StoreSvc;
import com.example.dal.order.CashActiveOrderDao;
import com.example.dal.order.entity.CashActiveOrder;

@Service
public class CashActiveOrderSvcImpl implements CashActiveOrderSvc {
	@Autowired
	private CashActiveOrderDao cashActiveOrderDao;

	@Autowired
	private StoreSvc storeSvc;

	@Override
	@Transactional
	public CashActiveOrder save(Integer storeUid, CashActiveOrder cashActiveOrder) {
		CashActiveOrder order = cashActiveOrderDao.save(cashActiveOrder);
		
		Integer posOrNeg = null;
		if(order.getAction().equals("deposit")) {
			posOrNeg = 1;
		} else if (order.getAction().equals("withdraw")) {
			posOrNeg = -1;
		}
		
		storeSvc.findByStoreUid(storeUid).addCash((order.getCash() * posOrNeg));
		
		return order;
	}

	@Override
	public List<CashActiveOrder> findAll() {
		return cashActiveOrderDao.findAll();
	}

}
