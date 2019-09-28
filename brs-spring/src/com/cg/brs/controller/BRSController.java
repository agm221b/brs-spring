package com.cg.brs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.brs.dto.Booking;
import com.cg.brs.service.BRSService;

@Controller
public class BRSController {
	
	@Autowired
	BRSService brsService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHomePage() {
		
		return "jsp/home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "jsp/login";
	}
	
	
	@RequestMapping(value = "/aboutus",method = RequestMethod.GET)
	public String showAboutUsPage() {
		return "jsp/aboutUs";
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public String showRegisterPage() {
		return "jsp/register";
	}
	
	@RequestMapping(value = "/help",method = RequestMethod.GET)
	public String showHelpPage() {
		return "jsp/help";
	}
	
	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public String showTestPage(@ModelAttribute("test") Booking booking) {
		return "jsp/test";
	}
	
	public String showBusDetails() {
		return "jsp/test";
	}

}
