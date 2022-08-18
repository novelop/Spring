package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;






@Controller
@RequestMapping("/picture")
public class PictureController {
	
	@RequestMapping("/main")
	public String main()throws Exception{
		String url="member/image";
		return url;
	}
	
	@GetMapping("/display")
	public ResponseEntity<byte[]> getPicture(String fileName)throws Exception{
		File file = new File("D:\\team1\\Hello\\"+fileName);
		ResponseEntity<byte[]> result = null;
		
		try {
			
			//HttpHeaders header = new HttpHeaders();
			//header.add("Content-type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),HttpStatus.OK);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
