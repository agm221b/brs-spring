package com.cg.brs.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.brs.dto.Booking;
import com.cg.brs.dto.Bus;
import com.cg.brs.dto.BusTransaction;
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
	
	@RequestMapping(value="/addbus", method = RequestMethod.GET)
	public String addBus(@ModelAttribute("bus") Bus bus) { 
		return "jsp/Admin/AddBus";
	}
	
	@RequestMapping(value="/addbusdetails",method=RequestMethod.POST)
	public String addBusDetails(@ModelAttribute("bus") Bus bus) {
		System.out.println(bus);
		brsService.addBusDetails(bus);
		
		for(int i=1;i<15;i++) {
			BusTransaction busTransaction=new BusTransaction();
			busTransaction.setDate(LocalDate.now().plusDays(i));
			busTransaction.setBus(bus);
			busTransaction.setAvailableSeats(bus.getNoOfSeats());
			busTransaction.setDeleteFlag(0);
			brsService.addTransaction(busTransaction);
		}
		return "jsp/home";
	}
	
	@RequestMapping(value="/searchbuses",method=RequestMethod.GET)
	public String searchBuses() {
		return "jsp/Customer/SearchBus";
		
	}
	
	@RequestMapping(value="/showrunningbuses",method=RequestMethod.POST)
	public ModelAndView showRunningBuses(@RequestParam("source")String source,@RequestParam("destination")String destination, @RequestParam("date_of_journey")String dateOfJourney) {
		System.out.println(source+" "+destination+" "+dateOfJourney);
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate journeyDate=LocalDate.parse(dateOfJourney, formatter);
		List<BusTransaction> transactionList=brsService.searchBuses(source, destination, journeyDate);
		List<BusTransaction> transactionsByDate=new ArrayList<BusTransaction>();
		for(BusTransaction busTransaction:transactionList) {
			transactionsByDate.add(busTransaction);
		}
		System.out.println(transactionsByDate);
		return new ModelAndView("searchBus", "transactions", transactionsByDate);
	}

}
