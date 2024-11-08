package org.freecode.demo.springboot3mvc.controller;

import java.util.List;

import org.freecode.demo.springboot3mvc.model.RegisteredUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

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
	/**
	 * URL: http://<server>:<port>/register
	 * @param theModel - allows sharing information between controllers and views
	 * @return
	 */
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
	 * URL: http://<server>:<port>/confirmRegistration
	 * @param theUser
	 * @return
	 */
	public String confirmUserRegistration(@Valid @ModelAttribute("registeredUser") RegisteredUser theUser, BindingResult theBandingResult) {
		
		// Todo: process to register the user eg add the registration to the database
		
		System.out.println(theUser);
		if (theBandingResult.hasErrors()) {
			
			System.out.println("theBandingResult: " + theBandingResult);
			
			return "userRegistrationForm";
		}
		
		return "registrationConfirmation"; // registrationConfirmation.html
	}
	
	@InitBinder
	/**
	 * @InitBinder works as a pre-processor to all the requests
	 * @param dataBinder
	 */
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}
