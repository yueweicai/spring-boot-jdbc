package com.orilore.dao.impls;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.orilore.dao.IDeptDAO;
import com.orilore.model.Dept;
import com.orilore.model.util.DeptRowMapper;

@Repository
public class DeptDAO implements IDeptDAO{
	@Resource
	private JdbcTemplate template;
	@Override
	public List<Dept> select() {
		return this.template.query("select * from dept where status!=-1 order by id desc", new DeptRowMapper());
	}
	@Override
	public boolean insert(Dept bean) {
		int n = this.template.update("insert into dept(name) values(?)",bean.getName());
		if(n>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean update(Dept bean) {
		Object[] ps = new Object[]{
				bean.getName(),
				bean.getId()
		};
		int n = this.template.update("update dept set name=? where id=?",ps);
		if(n>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean delete(int id) {
		int n = this.template.update("update dept set status=-1 where id=?",id);
		if(n>0){
			return true;
		}
		return false;
	}
	@Override
	public Dept selectOne(int id) {
		/************解决方案A*****************/
		//		Map<String,Object> map = this.template.queryForMap("select * from dept where id=?",id);
		//		Dept bean = new Dept();
		//		bean.setId((Integer)map.get("id"));
		//		bean.setName((String)map.get("name"));
		//		bean.setStatus((Integer)map.get("status"));
		//		return bean;
		/************解决方案B*****************/
		Object[] ps = new Object[]{id};
		DeptRowMapper mapper = new DeptRowMapper();
		return this.template.queryForObject("select * from dept where id=?",ps,mapper);
	}
}
