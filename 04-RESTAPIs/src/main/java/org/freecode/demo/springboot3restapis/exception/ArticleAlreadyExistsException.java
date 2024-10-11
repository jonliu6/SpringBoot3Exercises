package org.freecode.demo.springboot3restapis.exception;

public class ArticleAlreadyExistsException extends RuntimeException{
	
	public ArticleAlreadyExistsException(String message) {
		super(message);
	}

}
