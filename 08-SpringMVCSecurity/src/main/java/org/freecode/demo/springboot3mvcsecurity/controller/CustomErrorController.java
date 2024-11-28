package org.freecode.demo.springboot3mvcsecurity.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

	@GetMapping("/error")
	public String handleError(Model theModel, HttpServletRequest httpReq) {
		Object httpStatus = httpReq.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (httpStatus != null) {
			theModel.addAttribute("httpStatusCode", String.valueOf(httpStatus));
		}
		
		return "error";
	}
}
