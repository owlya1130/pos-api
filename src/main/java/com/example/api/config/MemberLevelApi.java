package com.example.api.config;

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

import com.example.bll.config.MemberLevelSvc;
import com.example.dal.config.entity.MemberLevel;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("member-level")
public class MemberLevelApi {
	@Autowired
	private MemberLevelSvc memberLevelSvc;
	
	@PostMapping
	MemberLevel save(@RequestBody MemberLevel memberLevel) {
		return memberLevelSvc.save(memberLevel);
	}
	
	@PutMapping
	MemberLevel update(@RequestBody MemberLevel memberLevel) {
		return memberLevelSvc.update(memberLevel);
	}
	
	@DeleteMapping("{level_uid}")
	void delete(@PathVariable(name="level_uid") Integer levelUid) {
		memberLevelSvc.delete(levelUid);
	}

	@GetMapping("{level_uid}")
	MemberLevel find(@PathVariable(name = "level_uid") Integer levelUid) {
		return memberLevelSvc.find(levelUid);
	}
	
	@GetMapping("list")
	List<MemberLevel> findAll() {
		return memberLevelSvc.findAll();
	}
}
