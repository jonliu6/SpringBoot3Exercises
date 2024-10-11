package org.freecode.demo.springboot3restapisecurity.exception;

public class ArticleAlreadyExistsException extends RuntimeException{
	
	public ArticleAlreadyExistsException(String message) {
		super(message);
	}

}
