package com.test.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TxDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(String schoolName) {
		String sql="insert into school(name) values(?)";
		jdbcTemplate.update(sql, schoolName);
	}

}
