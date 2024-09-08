package org.freecode.demo.springboot3quickstart.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuickStartController {
	@Value("${info.app.name}")
	private String appName; 

	@GetMapping("/greeting")
	public String Greeting() {
		return "Hello from " + appName;
	}
}
