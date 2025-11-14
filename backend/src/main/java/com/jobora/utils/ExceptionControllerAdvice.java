package com.jobora.utils;

import java.time.LocalDateTime;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jobora.custom.exception.JoboraException;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	@Autowired
	private Environment env;
	
	/*
	 *  Exception Handler for Custom Exception 
	 *  
	 */
	@ExceptionHandler(JoboraException.class)
	public ResponseEntity<ErrorInfo> generalException(JoboraException ex) {
		  String msg = env.getProperty(ex.getMessage());
		ErrorInfo errorInfo = new ErrorInfo(msg, HttpStatus.BAD_REQUEST.value(),
				LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.BAD_REQUEST);
	}
	
	
	/*
	 *   global Exception Handler
	 *  
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> generalException(Exception ex) {
		ErrorInfo errorInfo = new ErrorInfo(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	/* 
	 *  Exception Handler for validation and constraint like not null for a method 
	 *  
	 */
	@ExceptionHandler({ MethodArgumentNotValidException.class, ConstraintViolationException.class })
	public ResponseEntity<ErrorInfo> validatorExceptionHandler(Exception ex) {
		String msg = " ";

		if (ex instanceof MethodArgumentNotValidException mvEx) {
			msg = mvEx.getAllErrors().stream().map(error -> error.getDefaultMessage())
					.collect(Collectors.joining(", "));

		} else {
			ConstraintViolationException constraintEx = (ConstraintViolationException) ex;
			msg = constraintEx.getConstraintViolations().stream().map(violation -> violation.getMessage())
					.collect(Collectors.joining(", "));

		}
		ErrorInfo errorInfo = new ErrorInfo(msg, HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.BAD_REQUEST);
	}

}
