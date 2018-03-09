package com.orilore.dao;

import java.util.List;
import com.orilore.model.Person;

public interface IPersonDAO {
	public List<Person> select(Person bean);
	public boolean insert(Person bean);
	public boolean update(Person bean);
	public boolean delete(int id);
	public Person selectOne(int id);
}
