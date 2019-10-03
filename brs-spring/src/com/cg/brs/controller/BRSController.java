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

	@RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
	public String showAboutUsPage() {
		return "jsp/aboutUs";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterPage(@ModelAttribute("user") User user) {
		return "jsp/register";
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("Hi");
			return "jsp/register";
		} else {
			brsService.addUser(user);
			return "jsp/home";
		}
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public ModelAndView getExcel() {
		User user = (User) session.getAttribute("user");
		List<Booking> bookingList = user.getBookingsList();
		return new ModelAndView(new ExcelReportView(), "bookingList", bookingList);
	}

	@RequestMapping(value = "/help", method = RequestMethod.GET)
	public String showHelpPage() {
		return "jsp/help";
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
			return "jsp/Admin/AdminHome";
		}
	}

	@RequestMapping(value = "/searchbuses", method = RequestMethod.GET)
	public String searchBuses() {
		return "jsp/Customer/SearchBus";

	}

	@RequestMapping(value = "/showbuses", method = RequestMethod.GET)
	public ModelAndView getAllData() { // admin
		List<Bus> busList = brsService.viewAllBuses();
		return new ModelAndView("jsp/Admin/ShowBuses", "busList", busList);
	}

	@RequestMapping(value = "/showrunningbuses", method = RequestMethod.POST)
	public ModelAndView showRunningBuses(@ModelAttribute("bus") Bus bus,
			@RequestParam("date_of_journey") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfJourney,
			Map<String, Object> dropdown) {
		List<String> src = brsService.findSrc();
		List<String> dest = brsService.findDest();
		System.out.println(src);
		dropdown.put("src", src);
		dropdown.put("dest", dest);
		session.setAttribute("dateOfJourney", dateOfJourney);
		session.setAttribute("source", bus.getSource());
		session.setAttribute("destination", bus.getDestination());
		List<BusTransaction> transactionList = brsService.searchBuses(bus.getSource(), bus.getDestination(),
				dateOfJourney);
		System.out.println(transactionList);
		return new ModelAndView("jsp/Customer/SearchBus", "transactionList", transactionList);
	}

	@RequestMapping(value = "/deletebus", method = RequestMethod.GET)
	public String deleteBus(@RequestParam("busId") Integer busId) {
		brsService.removeBus(busId);

		return "jsp/Admin/DeleteBuses";
	}

	@RequestMapping(value = "/addbooking", method = RequestMethod.GET)
	public String addBooking(@ModelAttribute("bus") Bus bus, Map<String, Object> dropdown) {
		List<String> src = brsService.findSrc();
		List<String> dest = brsService.findDest();
		System.out.println(src);
		dropdown.put("src", src);
		dropdown.put("dest", dest);
		return "jsp/Customer/AddBooking";
	}

	@RequestMapping(value = "/addpassenger", method = RequestMethod.GET)
	public String addPassenger(@ModelAttribute("passenger") Passenger passenger) {
		return "jsp/Customer/AddPassenger";
	}

	@RequestMapping(value = "/addpassengerdetails", method = RequestMethod.POST)
	public ModelAndView addPassengerDetails(@Valid @ModelAttribute("passenger") Passenger passenger,
			BindingResult result) {
		if (result.hasErrors()) {
			return null;
		} else {

			System.out.println(passenger);
			List<Passenger> passengerList = (List<Passenger>) session.getAttribute("passengerList");
			Booking booking = (Booking) session.getAttribute("booking");
			passengerList.add(passenger);
			booking.setPassengers(passengerList);

			return new ModelAndView("jsp/Customer/AddPassenger", "passengers", passengerList);

		}
	}

	@RequestMapping(value = "/createbooking", method = RequestMethod.GET)
	public ModelAndView createBooking(@RequestParam("transactionId") Integer busTransactionId) {
		BusTransaction busTransaction = brsService.viewTransactionById(busTransactionId);
		session.setAttribute("transactionId", busTransactionId);
		session.setAttribute("busId", busTransaction.getBus().getBusId());
		session.setAttribute("availableSeats", busTransaction.getAvailableSeats());
		List<BusTransaction> currentBusTransaction = new ArrayList<BusTransaction>();
		currentBusTransaction.add(busTransaction);
		Booking booking = new Booking();
		booking.setDateOfJourney((LocalDate) session.getAttribute("dateOfJourney"));
		booking.setBus(busTransaction.getBus());
		List<Passenger> passengerList = new ArrayList<Passenger>();
		session.setAttribute("passengerList", passengerList);
		session.setAttribute("booking", booking);
		System.out.println((Booking) session.getAttribute("booking"));

		return new ModelAndView("jsp/Customer/createBooking", "bus", currentBusTransaction);

	}

	@RequestMapping(value = "/cancelbooking", method = RequestMethod.GET)
	public String cancelBooking(@RequestParam("bookingId") Integer bookingId) {
		System.out.println(bookingId);
		brsService.cancelBooking(bookingId);
		Booking booking = brsService.findBookingById(bookingId);
		System.out.println(booking);
		session.setAttribute("booking", booking); // failed to initialize
		return "jsp/Customer/CancelBooking";
	}

	@RequestMapping(value = "/viewupdatedbookings")
	public ModelAndView updateBookingsList() {
		User user = (User) session.getAttribute("user");
		List<Booking> bookings = user.getBookingsList();
		System.out.println("bookings");
		return new ModelAndView("jsp/Customer/UpdatedBookings", "bookings", bookings);
	}

	@RequestMapping(value = "/confirmation", method = RequestMethod.GET)
	public String confirmPayment() {
		return "jsp/Customer/payment";
	}

	@RequestMapping(value = "/paymentdetails", method = RequestMethod.POST)
	public String confirmBooking(@RequestParam("paymentMode") String paymentMode) {
		Booking booking = (Booking) session.getAttribute("booking");
		booking.setModeOfPayment(paymentMode);
		System.out.println(booking);
		return "jsp/Customer/confirmation";

	}

	@RequestMapping(value = "/viewcurrentbooking", method = RequestMethod.GET)
	public ModelAndView viewCurrentBooking(Map<String, Object> model) {

		Booking booking = (Booking) session.getAttribute("booking");
		List<Passenger> passengerList = (List<Passenger>) session.getAttribute("passengerList");
		System.out.println(passengerList);
		int passengersCount = passengerList.size();
		Integer busId = (Integer) session.getAttribute("busId");
		Bus bus = brsService.viewBusById(busId);
		booking.setBookingId(booking.getBookingId());
		booking.setTotalCost(passengersCount * bus.getCostPerSeat());
		booking.setBookingStatus("BOOKED");
		User user = (User) session.getAttribute("user");
		booking.setUser(user);
		booking.setDeleteFlag(0);
		Integer busTransactionId = (Integer) session.getAttribute("transactionId");
		brsService.updateAvailableSeats(busTransactionId, passengersCount);
		List<Booking> bookings = new ArrayList<Booking>();
		bookings.add(booking);
		brsService.createBooking(booking);

		model.put("passengers", passengerList);
		return new ModelAndView("jsp/Customer/currentBooking", "bookings", bookings);

	}

	@RequestMapping(value = "/cancelcurrentbooking", method = RequestMethod.GET)
	public String cancelCurrentBooking() {
		Booking booking = (Booking) session.getAttribute("booking");
		brsService.cancelBooking(booking.getBookingId());
		return "jsp/Customer/CancelBooking";
	}

	@RequestMapping(value = "/viewallbookings", method = RequestMethod.GET)
	public ModelAndView viewAllBookings() {
		User user = (User) session.getAttribute("user");
		List<Booking> bookingsList = user.getBookingsList();
		System.out.println(bookingsList);
		return new ModelAndView("jsp/Customer/ViewBookings", "bookings", bookingsList);
	}

	@RequestMapping(value = "/showusers", method = RequestMethod.GET)
	public ModelAndView showAllUsers() {
		List<User> userList = brsService.viewAllUsers();
		return new ModelAndView("jsp/Admin/ShowAllUsers", "userList", userList);
	}

}
