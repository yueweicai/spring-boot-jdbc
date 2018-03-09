package com.orilore.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orilore.dao.IDeptDAO;
import com.orilore.model.Dept;

@RestController
public class DeptCtrl {
	
	@Resource
	private IDeptDAO dao;
	
	@RequestMapping("/dept/query")
	public List<Dept> query(){
		return this.dao.select();
	}
	
}
