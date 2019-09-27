package com.cg.brs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.brs.service.BRSService;

@Controller
public class BRSController {
	
	@Autowired
	BRSService brsService;

	@RequestMapping(value = "/myfirst", method = RequestMethod.GET)
	public String showHomePage() {
		return "jsp/home";
	}

}
