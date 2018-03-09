package com.orilore.model.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.orilore.model.Person;

public class PersonRowMapper implements RowMapper<Person>{
	@Override
	public Person mapRow(ResultSet rs, int arg) throws SQLException {
		Person bean = new Person();
		bean.setId(rs.getInt("id"));
		bean.setName(rs.getString("name"));
		bean.setBirthday(rs.getString("birthday"));
		bean.setAddr(rs.getString("addr"));
		bean.setPhone(rs.getString("phone"));
		bean.setSex(rs.getString("sex"));
		bean.setDeptid(rs.getInt("deptid"));
		bean.setDname(rs.getString("dname"));
		return bean;
	}
}
