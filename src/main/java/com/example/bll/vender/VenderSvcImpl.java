package com.example.bll.vender;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dal.vender.VenderDao;
import com.example.dal.vender.entity.Vender;

@Service
public class VenderSvcImpl implements VenderSvc {
	@Autowired
	private VenderDao venderDao;
	
	@Override
	@Transactional
	public Vender save(Vender vender) {
		return venderDao.save(vender);
	}

	@Override
	@Transactional
	public Vender update(Vender vender) {
		boolean isEmpty = venderDao.findById(vender.getVenderUid()).isEmpty();
		if(isEmpty) {
			throw new RuntimeException("vender is not exist");
		}
		return venderDao.save(vender);
	}

	@Override
	public void delete(Integer venderUid) {
		venderDao.deleteById(venderUid);
	}

	@Override
	public Vender findByVenderUid(Integer venderUid) {
		return venderDao.findById(venderUid).get();
	}

	@Override
	public List<Vender> findAll() {
		return venderDao.findAll();
	}

}
