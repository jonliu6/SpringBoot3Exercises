package org.freecode.demo.springboot3mvccrud.controller;

import java.util.List;

import org.freecode.demo.springboot3mvccrud.model.RegisteredUser;
import org.freecode.demo.springboot3mvccrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	
	@Value("${occupations}")
	/**
	 * @Value is used to load the list of values from the application property file
	 */
	private List<String> occupations;
	
	@Value("${genders}")
	private List<String> genders;

	
	@Autowired
	public UserController(UserService usrSvc) {
		this.userService = usrSvc;
	}
	
	@GetMapping("/list")
	/**
	 * retrieve all the registered users from DB, add to the model attribute, and redirect to the listUsers.html
	 * URL: http://<server>:<port>/users/list
	 * @param theModel
	 * @return
	 */
	public String viewRegisteredUsers(Model theModel) {
		
		List<RegisteredUser> allUsers = userService.findAll();
		theModel.addAttribute("registeredUsers", allUsers);
		
		return "listUsers";
	}
	
	@GetMapping("/showNewRegistrationForm")
	public String showNewRegistrationForm(Model theModel) {
		RegisteredUser newUser = new RegisteredUser();
		theModel.addAttribute("aUser", newUser);
		// add other model attributes using predefined values from the properties
		theModel.addAttribute("occupationOptions", occupations);
		theModel.addAttribute("genderOptions", genders);

		
		return "registerUser";
	}
	
	@PostMapping("/processRegistration")
	public String processUserRegistration(Model theModel, @Valid @ModelAttribute("aUser") RegisteredUser aUser, BindingResult theBandingResult) {
		theModel.addAttribute("occupationOptions", occupations);
	    theModel.addAttribute("genderOptions", genders);
		
        if (theBandingResult.hasErrors()) {
			
			System.out.println("theBandingResult: " + theBandingResult);
			return "registerUser";
		}
        
        userService.save(aUser);
		
		return "redirect:/users/list";
	}
	
	@GetMapping("/showUserRegistrationForm")
	public String showExistingRegistrationForm(@RequestParam("userEmail") String email, Model theModel) {
		RegisteredUser regUser = userService.findById(email);
		theModel.addAttribute("aUser", regUser);
		theModel.addAttribute("occupationOptions", occupations);
		theModel.addAttribute("genderOptions", genders);
		
		return "registerUser";
	}
	
	@GetMapping("/deleteRegistration")
	public String deleteUserRegistration(@RequestParam("userEmail") String email) {
		userService.deleteById(email);
		
		return "redirect:/users/list";
	}
}
