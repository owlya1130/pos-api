package com.example.bll.vender;

import java.util.List;

import com.example.dal.vender.entity.Vender;

public interface VenderSvc {
	public Vender save(Vender vender);
	public Vender update(Vender vender);
	public void delete(Integer venderUid);
	public Vender findByVenderUid(Integer venderUid);
	public List<Vender> findAll();
}
