package com.prowings.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
	
	public static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	
	@GetMapping("/hello")
	public String hello() {
		
//		System.out.println("Request received in /hello ");
		
		
		logger.info("Request received in /hello ");
		
		return "Hello...Welcome to Spring-MVC-Rest!!!";
	}
	
}
