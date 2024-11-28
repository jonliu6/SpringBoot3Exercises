package org.freecode.demo.springboot3mvcsecurity.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@Value("${sprint.application.description}")
	private String applicationName;

	@GetMapping("/home")
	public String showHomepage(Model theModel) {
		theModel.addAttribute("application_description", applicationName);
		theModel.addAttribute("system_time", new Date());
		return "home";
	}
	
	@GetMapping("/contribution")
	public String showContributorPage(Model theModel) {
		return "contribution";
	}
	
	@GetMapping("/administration")
	public String showAdministratorPage(Model theModel) {
		return "administration";
	}
}
