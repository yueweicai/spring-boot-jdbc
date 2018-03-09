package com.orilore.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orilore.dao.IPersonDAO;
import com.orilore.model.Person;

@RestController
public class PersonCtrl {
	@Resource
	private IPersonDAO dao;
	
	@RequestMapping("/person/query")
	public List<Person> query(Person bean){
		return dao.select(bean);
	}
	
	@RequestMapping("/person/save")
	public boolean save(Person bean){
		if(bean.getId()>0){
			return this.dao.update(bean);
		}else{
			return this.dao.insert(bean);
		}
	}
	
	@RequestMapping("/person/remove/{id}")
	public boolean remove(@PathVariable("id") int id){
		return this.dao.delete(id);
	}
}
