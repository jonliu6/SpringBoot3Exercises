package org.freecode.demo.springboot3core;

import org.springframework.stereotype.Component;

@Component
public class SoftwareDeveloper implements ITProjectResource{
	
	public SoftwareDeveloper() {
		System.out.println("SoftwareDeveloper constructor called");
	}

	@Override
	public String showTitle() {
		return "Software Developer";
	}

}
