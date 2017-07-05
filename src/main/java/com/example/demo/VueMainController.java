package com.example.demo;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping("/upvoteBoard/{no}")
	@ResponseBody
	public Object upvoteBoard(@PathVariable int no, @RequestParam Map<String, Object> ModelMap) {
		System.out.println("no >>> "+no);
		System.out.println("no >>> "+ModelMap.get("no"));
		System.out.println("writer >>> "+ModelMap.get("writer"));
		System.out.println("subject >>> "+ModelMap.get("subject"));
		System.out.println("content >>> "+ModelMap.get("content"));
		System.out.println("hit >>> "+ModelMap.get("hit"));
		System.out.println("regdate >>> "+ModelMap.get("regdate"));
		
		
		int result = sampleDAO.updateUpvoteBoard(no);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("ret", result);
		return map;
	}
	
	@RequestMapping("/upvoteBoard2/{no}")
	@ResponseBody
	public Object upvoteBoard2(@PathVariable int no, @RequestBody Map<String, Object> ModelMap) {
		System.out.println("no >>> "+no);
		System.out.println("no >>> "+ModelMap.get("no"));
		System.out.println("writer >>> "+ModelMap.get("writer"));
		System.out.println("subject >>> "+ModelMap.get("subject"));
		System.out.println("content >>> "+ModelMap.get("content"));
		System.out.println("hit >>> "+ModelMap.get("hit"));
		System.out.println("regdate >>> "+ModelMap.get("regdate"));
		
		
		int result = sampleDAO.updateUpvoteBoard(no);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("ret", result);
		return map;
	}
	
	@RequestMapping("/deleteBoard/{no}")
	@ResponseBody
	public Object deleteBoard(@PathVariable int no) {
		System.out.println("no >>> "+no);
		// 실제로 삭제하지 않고 update만 한다.
		int result = sampleDAO.updateUpvoteBoard(no);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("ret", result);
		return map;
	}
	
	@RequestMapping("/updateBoard/{no}")
	@ResponseBody
	public Object updateBoard(@PathVariable int no, @RequestBody Map<String, Object> ModelMap) {
		
		// 실제로 삭제하지 않고 update만 한다.
		int result = sampleDAO.updateBoard(ModelMap);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("ret", result);
		return map;
	}
}