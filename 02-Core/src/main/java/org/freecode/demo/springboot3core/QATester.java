package org.freecode.demo.springboot3core;

import org.springframework.stereotype.Component;

@Component
public class QATester implements ITProjectResource {
	
	public QATester() {
		System.out.println("QATester constructor called");
	}

	@Override
	public String showTitle() {
		return "QA";
	}

}
