package org.freecode.demo.springboot3restapis.exception;

import org.freecode.demo.springboot3restapis.model.ArticleErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ArticleExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ArticleErrorResponse> handleExeption(ArticleNotFoundException ex) {
		ArticleErrorResponse error = new ArticleErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ArticleErrorResponse> handleException(ArticleAlreadyExistsException ex) {
		ArticleErrorResponse error = new ArticleErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<ArticleErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
}
