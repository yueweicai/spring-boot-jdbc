package com.orilore.dao;

import java.util.List;

import com.orilore.model.Dept;

public interface IDeptDAO {
	public List<Dept> select();
	public boolean insert(Dept bean);
	public boolean update(Dept bean);
	public boolean delete(int id);
	public Dept selectOne(int id);
}
