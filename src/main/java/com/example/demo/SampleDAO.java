package com.example.demo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		return template.queryForList(sql);
	}
	
	public int updateUpvoteBoard(int no){
		String sql = "update board set hit = hit+1 where no = ?;";
		return template.update(sql, no);
	}
	
	public int  updateBoard(Map<String, Object> map){
		String sql = "update board set subject = ?, content = ? where no = ?;";
		return template.update(sql, map.get("subject"), map.get("content"), map.get("no"));
	}
}
