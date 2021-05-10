package com.vijay.app.ex_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vijay.app.exception.StudentNameNotFoundException;
import com.vijay.app.exception.StudentRecordNotFoundException;

@ControllerAdvice
public class ExceptionHandling_Cls {
	
	@ExceptionHandler(value = StudentRecordNotFoundException.class)
	public ResponseEntity<Object> exception(StudentRecordNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = StudentNameNotFoundException.class)
	public ResponseEntity<Object> exception(StudentNameNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
