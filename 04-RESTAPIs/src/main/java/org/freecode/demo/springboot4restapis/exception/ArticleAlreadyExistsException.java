package org.freecode.demo.springboot4restapis.exception;

public class ArticleAlreadyExistsException extends RuntimeException{
	
	public ArticleAlreadyExistsException(String message) {
		super(message);
	}

}
