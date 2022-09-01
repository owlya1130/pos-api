package com.example.bll.order;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bll.order.bo.StockinOrderBO;
import com.example.bll.product.ProductQuantitySvc;
import com.example.dal.order.StockinOrderDao;
import com.example.dal.order.StockinOrderDetailDao;
import com.example.dal.order.entity.StockinOrder;

@Service
public class StockinOrderSvcImpl implements StockinOrderSvc {
	@Autowired
	private StockinOrderDao stockinOrderDao;
	@Autowired
	private StockinOrderDetailDao StockinOrderDetailDao;
	
	@Autowired
	private ProductQuantitySvc productQuantitySvc;

	@Override
	@Transactional
	public StockinOrderBO save(StockinOrderBO stockinOrderBO) {
		StockinOrder order = stockinOrderDao.save(stockinOrderBO.getOrder());
		Integer orderUid = order.getStockinUid();
		stockinOrderBO.getDetails().stream()
			.forEach(detail -> {
				detail.setStockinUid(orderUid);
				StockinOrderDetailDao.save(detail);
				productQuantitySvc
					.findByProductUidAndStoreUid(
						detail.getProductUid(), 
						order.getStoreUid())
					.addQuantity(detail.getTotalQuantity());
			});
		
		return findByOrderUid(orderUid);
	}

	@Override
	public List<StockinOrder> findAll() {
		return stockinOrderDao.findAll();
	}

	@Override
	public StockinOrderBO findByOrderUid(Integer orderUid) {
		return new StockinOrderBO(
				stockinOrderDao.findById(orderUid).get(), 
				StockinOrderDetailDao.findByStockinUid(orderUid));
	}

}
