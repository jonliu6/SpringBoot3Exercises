package org.freecode.demo.springboot4restapis.exception;

public class ArticleNotFoundException extends RuntimeException {

	public ArticleNotFoundException(String message) {
		super(message);
	}
}
