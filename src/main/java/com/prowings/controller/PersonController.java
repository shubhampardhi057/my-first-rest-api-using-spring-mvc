package com.prowings.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.entity.Person;
import com.prowings.service.VoterService;
@RestController
public class PersonController {
	
	public static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	VoterService voterService;
	
	
	
	@PostMapping("/vote")
	public ResponseEntity<String> doVote(@RequestBody Person person)
	{
		logger.info("Request received in /vote Person : {} Object ",person);
		
		String res = voterService.doVote(person);
		
		ResponseEntity<String> response = new ResponseEntity<String>(res,HttpStatus.OK);
		
		return response;
		
	}
}
