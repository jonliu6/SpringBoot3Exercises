package org.freecode.demo.springboot3mvc.controller;

import java.util.List;

import org.freecode.demo.springboot3mvc.model.RegisteredUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
	
	@Value("${occupations}")
	/**
	 * @Value is used to load the list of values from the application property file
	 */
	private List<String> occupations;
	
	@Value("${genders}")
	private List<String> genders;
	
	@Value("${topics}")
	private List<String> topics;

	@GetMapping("/register")
	public String showRegistrationForm(Model theModel) {
		// initiate a new user object for a new registration
		RegisteredUser user = new RegisteredUser();

		// add the new user to the model
		theModel.addAttribute("registeredUser", user);
		
		// add other model attributes using predefined values from the properties
		theModel.addAttribute("occupationOptions", occupations);
		theModel.addAttribute("genderOptions", genders);
		theModel.addAttribute("topicOptions", topics);
		
		return "userRegistrationForm"; // matches the filename of userRegistrationForm.html without the extension
	}
	
	@PostMapping("/confirmRegistration")
	/**
	 * Note: ModelAttribute name matches the attribute name added into the model
	 * @param theUser
	 * @return
	 */
	public String confirmUserRegistration(@ModelAttribute("registeredUser") RegisteredUser theUser) {
		
		// Todo: process to register the user eg add the registration to the database
		
		System.out.println(theUser);
		
		return "registrationConfirmation"; // registrationConfirmation.html
	}
}
