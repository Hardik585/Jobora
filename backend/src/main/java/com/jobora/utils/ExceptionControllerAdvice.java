package com.jobora.utils;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.method.MethodValidationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> generalException(Exception ex) {
		ErrorInfo errorInfo = new ErrorInfo(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	
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
