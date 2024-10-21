package org.freecode.demo.springboot3mvc.controller;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DemoController {
	
	@GetMapping("/time")
	/**
	 * URL: http://<server>:<port>/time
	 * @param aModel
	 * @return
	 */
	public String showServerTime(Model aModel) {
		aModel.addAttribute("systemTime", LocalTime.now());
		return "showTime"; // the web page name in /src/main/resources/templates
	}

	@RequestMapping("/inputForm")
	public String showForm() {
		
		return "userInputForm";
	}
	
	@RequestMapping("/confirmUserInfo")
	/**
	 * user HTTP Servlet Request to pass parameters
	 * @param req
	 * @param aModel
	 * @return
	 */
	public String confirmUserInfo(HttpServletRequest req, Model aModel) {
		String userName = req.getParameter("userName");
		userName = userName.toUpperCase();
		aModel.addAttribute("userName", userName);
		
		return "userConfirmation";
	}
	
	//@RequestMapping(path="/confirmUserInfo2", method = RequestMethod.POST)
	@PostMapping("/confirmUserInfo2")
	/**
	 * use Spring @RequestParam to pass parameters
	 * @param aName
	 * @param aModel
	 * @return
	 */
	public String confirmUserInfo2(@RequestParam("userName") String aName, Model aModel) {
		aName = aName.toUpperCase();
		aModel.addAttribute("userName", aName);
		
		return "userConfirmation";
	}
}
