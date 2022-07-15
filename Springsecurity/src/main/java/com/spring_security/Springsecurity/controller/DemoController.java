package com.spring_security.Springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

	
	@GetMapping("/home")
	public String home() {
		ModelAndView mav = new ModelAndView("home.jsp");
		return "home.jsp";
	}
}
