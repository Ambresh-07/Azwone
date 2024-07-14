package com.azome.dreamhome.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.azome.dreamhome.exceptions.UserNotFoundException;

@RestControllerAdvice
public class ExecptionHandller {

	// MethodArgumentNotValidException

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)

	public Map<String, String> InvalidArgumentException(MethodArgumentNotValidException ex) {

		Map<String, String> erromap = new HashMap<String, String>();

		ex.getBindingResult().getFieldErrors().forEach(error -> {

			erromap.put(error.getField(), error.getDefaultMessage());

		});

		return erromap;

	}

//	UserNotFoundException

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotFoundException.class)

	public Map<String, String> handleBusinessLogic(UserNotFoundException ex) {

		Map<String, String> errormap = new HashMap<String, String>();

		errormap.put("errorMessage", ex.getMessage());

		return errormap;

	}

//	HttpRequestMethodNotSupportedException

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<String> HttpRequestMethodNotSupportedException(
			HttpRequestMethodNotSupportedException methodNotsupportException) {
		return new ResponseEntity<String>("please change http method request... ", HttpStatus.NOT_FOUND);
	}

	// HttpMessageNotReadableException

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> HttpMessageNotReadableException(
			HttpMessageNotReadableException HttpMessageNotReadableExcep) {
		return new ResponseEntity<String>(
				"Please dont write Unexpected character with response body.please check response body",
				HttpStatus.BAD_REQUEST);
	}
	
	//NoResourceFoundException
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoResourceFoundException.class)
	
	public Map<String, String> NoResourceFoundException(NoResourceFoundException ex) {
		
		Map<String, String> errormap=new HashMap<String, String>();
		
		errormap.put("error_message",ex.getMessage());
		return errormap;
	}

}
