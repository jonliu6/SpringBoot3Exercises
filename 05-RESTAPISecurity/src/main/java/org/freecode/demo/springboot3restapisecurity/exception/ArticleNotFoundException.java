package org.freecode.demo.springboot3restapisecurity.exception;

public class ArticleNotFoundException extends RuntimeException {

	public ArticleNotFoundException(String message) {
		super(message);
	}
}
