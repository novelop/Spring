package com.spring.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/handlebars")
public class HandlebarsController {
	
	
	@RequestMapping("/main")
	public String main()throws Exception{
		String url="member/handlebars";
		return url;
	}
	
	@RequestMapping("/print")
	@ResponseBody
	public ResponseEntity <Map<String, Object>>  print(@RequestBody Map<String, Object> list) throws SQLException{
		ResponseEntity<Map<String, Object>> entity = null;
		System.out.println(list);
		try {
			
			entity = new ResponseEntity<Map<String, Object>>(list, HttpStatus.OK);
			
		} catch (Exception e) {
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return entity;
	}

}
