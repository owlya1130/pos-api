package com.example.bll.order;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bll.order.bo.DestoryOrderBO;
import com.example.bll.product.ProductQuantitySvc;
import com.example.dal.order.DestoryOrderDao;
import com.example.dal.order.DestoryOrderDetailDao;
import com.example.dal.order.entity.DestoryOrder;

@Service
public class DestoryOrderSvcImpl implements DestoryOrderSvc {
	@Autowired
	private DestoryOrderDao destoryOrderDao;
	@Autowired
	private DestoryOrderDetailDao destoryOrderDetailDao;
	
	@Autowired
	private ProductQuantitySvc productQuantitySvc;

	@Override
	@Transactional
	public DestoryOrderBO save(DestoryOrderBO destoryOrderBO) {
		DestoryOrder order = destoryOrderDao.save(destoryOrderBO.getOrder());
		Integer orderUid = order.getDestoryUid();
		
		destoryOrderBO.getDetails().stream()
			.forEach(detail -> {
				detail.setDestoryUid(orderUid);
				destoryOrderDetailDao.save(detail);
				
				productQuantitySvc
					.findByProductUidAndStoreUid(
						detail.getProductUid(), 
						order.getStoreUid())
					.addQuantity((detail.getQuantity() * -1));
			});
		
		
		return findByOrderUid(orderUid);
	}

	@Override
	public List<DestoryOrder> findAll() {
		return destoryOrderDao.findAll();
	}

	@Override
	public DestoryOrderBO findByOrderUid(Integer orderUid) {
		return new DestoryOrderBO(
				destoryOrderDao.findById(orderUid).get(),
				destoryOrderDetailDao.findByDestoryUid(orderUid));
	}

	@Override
	@Transactional
	public DestoryOrderBO audit(Integer orderUid, boolean isApprove) {
		DestoryOrderBO destoryOrderBO = findByOrderUid(orderUid);
		
		if(!isApprove) {
			destoryOrderBO.getDetails().stream()
			.forEach(detail -> {				
				productQuantitySvc
					.findByProductUidAndStoreUid(
						detail.getProductUid(), 
						destoryOrderBO.getOrder().getStoreUid())
					.addQuantity(detail.getQuantity());
			});
		}
		destoryOrderBO.getOrder().setApproved(isApprove);
		
		return findByOrderUid(orderUid);
	}

}
