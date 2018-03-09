package com.orilore.model.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.orilore.model.Dept;

public class DeptRowMapper implements RowMapper<Dept>{
	@Override
	public Dept mapRow(ResultSet rs, int arg) throws SQLException {
		Dept bean = new Dept();
		bean.setId(rs.getInt("id"));
		bean.setName(rs.getString("name"));
		bean.setStatus(rs.getInt("status"));
		return bean;
	}
}
