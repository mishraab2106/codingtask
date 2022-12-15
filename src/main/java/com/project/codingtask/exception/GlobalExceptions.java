package com.project.codingtask.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.codingtask.entity.ENewspaperModel;

//@RestControllerAdvice
public class GlobalExceptions {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> dataNotFoundHandler(MethodArgumentNotValidException ex){
		Map <String,String> resp=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
		String fieldName=((FieldError)error).getField();
		String message=error.getDefaultMessage();
		resp.put(fieldName,message);
		});
		return new ResponseEntity<Map <String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> generalException(Exception ex){

		return new ResponseEntity<String>("Please check the data provided",HttpStatus.BAD_REQUEST);
	}

}
