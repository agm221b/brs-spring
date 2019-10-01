package com.cg.brs.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.brs.dto.Booking;
import com.cg.brs.dto.Bus;
import com.cg.brs.dto.BusTransaction;
import com.cg.brs.dto.Passenger;
import com.cg.brs.dto.User;
import com.cg.brs.service.BRSService;

@Controller
public class BRSController {
	@Autowired
	HttpSession session;
	
	@Autowired
	BRSService brsService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHomePage() {
		return "jsp/home";
	}

	@RequestMapping(value = "/adminhome", method = RequestMethod.GET)
	public String viewAdminHome() {
		return "jsp/Admin/AdminHome";

	}

	@RequestMapping(value = "/customerhome", method = RequestMethod.GET)
	public String viewCustomerHome() {
		return "jsp/Customer/CustomerHome";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "jsp/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password, Map<String, Object> model, HttpSession session) {
		User user = brsService.validateUser(username, password);
		model.put("errormessage", "Invalid credentials");
		if (user != null) {
			session.setAttribute("user", user);
			if (user.getUserType() == 'C')
				return "jsp/Customer/CustomerHome";
			else if (user.getUserType() == 'A')
				return "jsp/Admin/AdminHome";
		}
		
		return "jsp/login";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "jsp/logout";
	}

	@RequestMapping(value = "/aboutus", method = RequestMethod.GET)
	public String showAboutUsPage() {
		return "jsp/aboutUs";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterPage(@ModelAttribute("user") User user) {
		return "jsp/register";
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("Hi");
		return "jsp/register";
		}
		else
		{
			brsService.addUser(user);
			return "jsp/home";
		}
	}

	@RequestMapping(value = "/help", method = RequestMethod.GET)
	public String showHelpPage() {
		return "jsp/help";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String showTestPage(@ModelAttribute("test") Booking booking) {
		return "jsp/test";
	}

	public String showBusDetails() {
		return "jsp/test";
	}

	@RequestMapping(value = "/addbus", method = RequestMethod.GET)
	public String addBus(@ModelAttribute("bus") Bus bus) {
		return "jsp/Admin/AddBus";
	}

	@RequestMapping(value = "/addbusdetails", method = RequestMethod.POST)
	public String addBusDetails(@Valid @ModelAttribute("bus") Bus bus, BindingResult result) {
		if (result.hasErrors()) {
			return "jsp/Admin/AddBus";

		} else {
			System.out.println(bus);
			brsService.addBusDetails(bus);

			for (int i = 1; i < 15; i++) {
				BusTransaction busTransaction = new BusTransaction();
				busTransaction.setDate(LocalDate.now().plusDays(i));
				busTransaction.setBus(bus);
				busTransaction.setAvailableSeats(bus.getNoOfSeats());
				busTransaction.setDeleteFlag(0);
				brsService.addTransaction(busTransaction);
			}
			return "jsp/home";
		}
	}

	@RequestMapping(value = "/searchbuses", method = RequestMethod.GET)
	public String searchBuses() {
		return "jsp/Customer/SearchBus";

	}

	@RequestMapping(value = "/showbuses", method = RequestMethod.GET)
	public ModelAndView getAllData() {
		List<Bus> busList = brsService.viewAllBuses();
		return new ModelAndView("jsp/Admin/ShowBuses", "busList", busList);
	}

	@RequestMapping(value = "/showrunningbuses", method = RequestMethod.POST)
	public ModelAndView showRunningBuses(@RequestParam("source") String source,
			@RequestParam("destination") String destination,
			@RequestParam("date_of_journey") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfJourney) {
		session.setAttribute("dateOfJourney", dateOfJourney);
		session.setAttribute("source", source);
		session.setAttribute("destination", destination);
		List<BusTransaction> transactionList = brsService.searchBuses(source, destination, dateOfJourney);
		System.out.println(transactionList);
		return new ModelAndView("jsp/Customer/SearchBus", "transactionList", transactionList);
	}

	@RequestMapping(value = "/addbooking", method = RequestMethod.GET)
	public String addBooking(@ModelAttribute("booking") Booking booking) {
		return "jsp/Customer/AddBooking";
	}

	@RequestMapping(value = "/addbookingdetails", method = RequestMethod.GET)
	public String addBookingDetails(@ModelAttribute("booking") Booking booking) {
		return "jsp/home";
	}

	@RequestMapping(value = "/addpassenger", method = RequestMethod.GET)
	public String addPassenger(@ModelAttribute("passenger") Passenger passenger) {
		return "jsp/Customer/AddPassenger";
	}

	@RequestMapping(value = "/addpassengerdetails", method = RequestMethod.POST)
	public ModelAndView addPassengerDetails(@Valid @ModelAttribute("passenger") Passenger passenger, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		} else {

			System.out.println(passenger);
			List<Passenger> passengerList=new ArrayList<Passenger>();
			brsService.addPassenger(passenger);
			passengerList.add(passenger);
			session.setAttribute("passengers", passenger);
			return new ModelAndView("jsp/Customer/AddPassenger", "passengers", passengerList);

		}
	}

	@RequestMapping(value = "/createbooking", method = RequestMethod.GET)
	public ModelAndView createBooking(@RequestParam("transactionId") Integer busTransactionId) {
		BusTransaction busTransaction=brsService.viewTransactionById(busTransactionId);
		session.setAttribute("transactionId", busTransactionId);
		session.setAttribute("busId", busTransaction.getBus().getBusId());
		session.setAttribute("availableSeats", busTransaction.getAvailableSeats());
		List<BusTransaction> currentBusTransaction=new ArrayList<BusTransaction>();
		currentBusTransaction.add(busTransaction);
		System.out.println(currentBusTransaction);
		Booking booking=new Booking();
		return new ModelAndView("jsp/Customer/createBooking", "bus", currentBusTransaction);

	}

	@RequestMapping(value = "/showbooking", method = RequestMethod.GET)
	public String showCurrentBooking() {
		return "";
	}

	@RequestMapping(value = "/showusers", method = RequestMethod.GET)
	public ModelAndView showAllUsers() {
		List<User> userList = brsService.viewAllUsers();
		return new ModelAndView("jsp/Admin/ShowAllUsers", "userList", userList);
	}

}
