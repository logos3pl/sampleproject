package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SampleDAO {

	@Autowired
	private JdbcTemplate template;
	
	public List<Map<String, Object>> selectBoradList(){
		String sql = "SELECT no, writer, subject, content, hit, regdate FROM board;";
		String args = "";
		return template.queryForList(sql);
	}
}
