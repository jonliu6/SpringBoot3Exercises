package org.freecode.demo.springboot3restapis.exception;

public class ArticleNotFoundException extends RuntimeException {

	public ArticleNotFoundException(String message) {
		super(message);
	}
}
