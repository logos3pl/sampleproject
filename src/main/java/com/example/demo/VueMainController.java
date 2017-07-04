package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VueMainController {
	
	@Autowired
	private SampleDAO sampleDAO;
	
	@RequestMapping("/main")
	@ResponseBody
	public Object index() {
		List<Map<String, Object>> mapList =  sampleDAO.selectBoradList();
		System.out.println("size : "+mapList.size());
		return mapList;
	}
}