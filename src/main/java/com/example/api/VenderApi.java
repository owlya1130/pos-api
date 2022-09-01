package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bll.vender.VenderSvc;
import com.example.dal.vender.entity.Vender;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("vender")
public class VenderApi {
	@Autowired
	private VenderSvc venderSvc;
	
	@PostMapping
	Vender save(@RequestBody Vender vender) {
		return venderSvc.save(vender);
	}
	
	@PutMapping
	Vender update(@RequestBody Vender vender) {
		return venderSvc.update(vender);
	}
	
	@DeleteMapping("{vender_uid}")
	void delete(@PathVariable(name="vender_uid") Integer venderUid) {
		venderSvc.delete(venderUid);
	}
	
	@GetMapping("{vender_uid}")
	Vender find(@PathVariable(name="vender_uid") Integer venderUid) {
		return venderSvc.findByVenderUid(venderUid);
	}
	
	@GetMapping("list")
	List<Vender> findAll() {
		return venderSvc.findAll();
	}
}
