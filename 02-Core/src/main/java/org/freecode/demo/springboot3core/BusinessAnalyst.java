package org.freecode.demo.springboot3core;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BusinessAnalyst implements ITProjectResource {

	public BusinessAnalyst() {
		System.out.println("BusinessAnalyst constructor called");
	}

	@Override
	public String showTitle() {
		return "BA";
	}
}
