package com.prowings.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.prowings.controller.HelloWorldController;
import com.prowings.entity.Error;

@ControllerAdvice
public class VoterServiceExceptionHandler {
	
	public static final Logger logger = LoggerFactory.getLogger(VoterServiceExceptionHandler.class);
	
	
	@ExceptionHandler(value = InvalidVoterException.class)
	public ResponseEntity  handleInvalidVoterException(Exception e,WebRequest request)
	{
//		System.out.println("Inside InvalidVoterException!!");
//		System.out.println("Invalid voter Exception occured!!");
//		System.out.println(e.getMessage());
//		System.out.println(request.getContextPath());
//		System.out.println(request.getParameterMap());
		
		logger.info("Inside InvalidVoterException !!");
		logger.info("Invalid voter Exception occured !!");
		logger.info(e.getMessage());
		logger.info(request.getContextPath());
		logger.info(null, request.getParameterMap());
		
		
		Error err = new Error();
		err.setErrorMessage(e.getMessage());
		err.setHttpStatus(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(err,err.getHttpStatus());
		
	}
	

}
