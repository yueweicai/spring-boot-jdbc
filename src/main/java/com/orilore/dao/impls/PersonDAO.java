package com.orilore.dao.impls;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.orilore.dao.IPersonDAO;
import com.orilore.model.Person;
import com.orilore.model.util.PersonRowMapper;
@Repository
public class PersonDAO implements IPersonDAO {
	@Resource
	private JdbcTemplate template;
	@Override
	public List<Person> select(Person bean) {
		String sql = "select a.*,b.name dname from person a left join dept b on a.deptid=b.id where a.status!=-1 ";
		String name = bean.getName();
		if(name!=null && !"".equals(name)){
			sql+=" and a.name like '%"+name+"%' ";
		}
		String sex = bean.getSex();
		if(sex!=null && !"".equals(sex)){
			sql+=" and a.sex='"+sex+"' ";
		}
		String phone = bean.getPhone();
		if(phone!=null && !"".equals(phone)){
			sql+=" and a.phone like '"+phone+"%' ";
		}
		int did = bean.getDeptid();
		if(did>0){
			sql+=" and deptid="+did+" ";
		}
		sql+=" order by a.id desc ";
		return this.template.query(sql,new PersonRowMapper());
	}

	@Override
	public boolean insert(Person bean) {
		Object[] ps = new Object[]{
				bean.getName(),
				bean.getSex(),
				bean.getBirthday(),
				bean.getPhone(),
				bean.getAddr(),
				bean.getDeptid()
		};
		String sql = "insert into person(name,sex,birthday,phone,addr,deptid) values(?,?,?,?,?,?)";
		if(this.template.update(sql,ps)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Person bean) {
		Object[] ps = new Object[]{
				bean.getName(),
				bean.getSex(),
				bean.getBirthday(),
				bean.getPhone(),
				bean.getAddr(),
				bean.getDeptid(),
				bean.getId()
		};
		String sql = "update person set name=?,sex=?,birthday=?,phone=?,addr=?,deptid=? where id=?";
		if(this.template.update(sql,ps)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		String sql = "update person set status=-1 where id=?";
		if(this.template.update(sql,id)>0){
			return true;
		}
		return false;
	}

	@Override
	public Person selectOne(int id) {
		String sql = "select * from person where id=?";
		Object[] ps = new Object[]{id};
		PersonRowMapper map = new PersonRowMapper();
		return this.template.queryForObject(sql,ps,map);
	}

}
