package com.cg.BrsSpringBootMVC.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.cg.BrsSpringBootMVC.dto.Booking;
import com.cg.BrsSpringBootMVC.dto.Bus;
import com.cg.BrsSpringBootMVC.dto.BusTransaction;
import com.cg.BrsSpringBootMVC.dto.Passenger;
import com.cg.BrsSpringBootMVC.dto.User;
import com.cg.BrsSpringBootMVC.exception.BRSException;
import com.cg.BrsSpringBootMVC.service.BRSService;
import com.cg.BrsSpringBootMVC.util.ExcelReportView;

/**
 * @author Aditya, Tejaswini, Mayank
 *
 */
@Controller
public class BRSController {
	@Autowired
	HttpSession session;

	@Autowired
	BRSService brsService;

	private static final Logger logger = LoggerFactory.getLogger(BRSController.class);

	/**
	 * @author Aditya
	 * Description: directs to the home page of the web site
	 * @return jsp/home
	 * Created On: 07-10-2019
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHomePage() {
		logger.debug("In Home now");
		return "jsp/home";
	}

	/**
	 * @author Aditya
	 * Description: directs to the home page of the admin
	 * @return jsp/Admin/AdminHome
	 * Created On: 07-10-2019
	 * 
	 */
	@RequestMapping(value = "/adminhome", method = RequestMethod.GET)
	public String viewAdminHome() {
		logger.debug("In Admin Home now");
		return "jsp/Admin/AdminHome";

	}

	/**
	 * @author Tejaswini
	 * Description: directs to the home page of the customer
	 * @return jsp/Customer/CustomerHome
	 * Created On: 07-10-2019
	 */
	@RequestMapping(value = "/customerhome", method = RequestMethod.GET)
	public String viewCustomerHome() {
		logger.debug("In Customer Home Now");
		String username=(String) session.getAttribute("username");
		
		User user=brsService.viewUserByUsername(username);
		session.setAttribute("user", user);
		return "jsp/Customer/CustomerHome";

	}

	/**
	 * @author Tejaswini
	 * Description: directs to the login page. Common for both admin and customer
	 * @return jsp/login
	 * Created On: 07-10-2019
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "jsp/login";
	}
	/**
	 * @author Tejaswini
	 * Description: logs out and redirects to the homepage of the website
	 * @param session
	 * @return jsp/logout
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		session.invalidate();
		return "jsp/logout";
	}

	/**
	 * @author Aditya Created: 8/10/19 Last Modified: 9/10/19 Description: redirects
	 *         to the aboutUs.jsp page
	 * @return
	 * @throws BRSException
	 */
	@RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
	public String showAboutUsPage() throws BRSException {

		return "jsp/aboutUs";
	}
	
	
	/**
	 * @author Aditya
	 * Description: Redirects user to the registration page
	 * @param user
	 * @return
	 * Created On : 08-10-2019
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterPage(@ModelAttribute("user") User user) {
		return "jsp/register";
	}

	/**
	 * @author Mayank Description: adds user and redirects to home.jsp page or
	 *         redirects to register.jsp page Created: 9/10/2019 Last Modified:
	 *         9/10/2019
	 * @return jsp/home
	 */
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		logger.info("In add user page");
		if (result.hasErrors()) {
			System.out.println("Hi");
			return "jsp/register";
		} else {
			List<Booking> bookingsList=new ArrayList<Booking>();
			user.setBookingsList(bookingsList);
			brsService.addUser(user);

			return "jsp/home";
		}
	}

	/**
	 * @author Aditya Created: 8/10/19 Last Modified: 9/10/19 Description: Downloads
	 *         the excel file containing all the bookings of that user
	 * @return
	 */
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public ModelAndView getExcel() {
		User user = (User) session.getAttribute("user");
		List<Booking> bookingList = user.getBookingsList();
		return new ModelAndView(new ExcelReportView(), "bookingList", bookingList);
	}

	/**
	 * @author Aditya Created: 8/10/19 Last Modified: 9/10/19 Description: redirects
	 *         to the help.jsp page
	 * @return
	 */
	@RequestMapping(value = "/help", method = RequestMethod.GET)
	public String showHelpPage() {
		throw new BRSException("HELP PAGE ERROR");
		// return "jsp/help";
	}

	/**
	 * @author Aditya Created: 8/10/19 Last Modified: 9/10/19 Description: redirects
	 *         to the AddBus.jsp page
	 * @param bus
	 * @return AddBus.jsp
	 */
	@RequestMapping(value = "/addbus", method = RequestMethod.GET)
	public String addBus(@ModelAttribute("bus") Bus bus) {
		return "jsp/Admin/AddBus";
	}

	/**
	 * @author Aditya Created: 8/10/19 Last Modified: 9/10/19 Description: sends the
	 *         bus data form and creates busTransaction
	 * @param bus
	 * @param result
	 * @return AdminHome.jsp
	 * @throws BRSException
	 */
	@RequestMapping(value = "/addbusdetails", method = RequestMethod.POST)
	public ModelAndView addBusDetails(@Valid @ModelAttribute("bus") Bus bus, BindingResult result) throws BRSException {
		String modelError = null;
		logger.info("Adding Bus into Database");
		
		if (result.hasErrors()) {
			return new ModelAndView("jsp/Admin/AddBus", "modelError", modelError);

		} else {
			logger.debug(bus.toString());

			try {
				for(Bus busExisting : brsService.viewAllBuses())
				{
					if(busExisting.equals(bus))
					{
						modelError = "Bus Already Exists in Database";
						logger.error("Bus Already Exists in Database");
						return new ModelAndView("jsp/Admin/AddBus", "modelError", modelError);
					}
				}
				brsService.addBusDetails(bus);
			} catch (BRSException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
				throw e;
			}

			for (int i = 1; i < 15; i++) {
				BusTransaction busTransaction = new BusTransaction();
				busTransaction.setDate(LocalDate.now().plusDays(i));
				busTransaction.setBus(bus);
				busTransaction.setAvailableSeats(bus.getNoOfSeats());
				busTransaction.setDeleteFlag(0);
				brsService.addTransaction(busTransaction);
				logger.info("Bus transactions created");
			}
			modelError = "Added Successfully";
			return new ModelAndView("jsp/Admin/AdminHome", "modelError", modelError);
		}
	}

	/**
	 * @author Aditya Created :8/10/19 Last Modified: 11/10/19 Description: Handles
	 *         arbitrary url by directing them to error page
	 * @param type
	 * @return error.jsp when wrong url is entered
	 * @throws Exception
	 */
	@RequestMapping(value = "/{type:.+}", method = RequestMethod.GET)
	public ModelAndView getPages(@PathVariable("type") String type) throws Exception {

		if ("error".equals(type)) { // go handleCustomException
			throw new BRSException("Incorrect Url Entered");
		} else if ("io-error".equals(type)) { // go handleAllException
			throw new IOException();
		} else {
			return new ModelAndView("jsp/error").addObject("ErrorMsg", type);
		}

	}

	/**
	 * @author Aditya Created :8/10/19 Last Modified: 11/10/19 Description: Handles
	 *         Bus not found exception
	 * @param ex
	 * @return ModelAndView to error.jsp
	 */
	/*
	 * @ExceptionHandler(BRSException.class) public ModelAndView
	 * handleCustomException(BRSException ex) {
	 * 
	 * ModelAndView model = new ModelAndView("jsp/error");
	 * model.addObject("ErrorMsg", ex.getMessage());
	 * 
	 * return model;
	 * 
	 * }
	 */
	/**
	 * /**
	 * 
	 * @author Aditya Created :8/10/19 Last Modified: 11/10/19 Description: Handles
	 *         any kinf of exception
	 * @param ex
	 * @return ModelAndView to error.jsp
	 */
	/*
	 * @ExceptionHandler(Exception.class) public ModelAndView
	 * handleAllException(Exception ex) {
	 * 
	 * ModelAndView model = new ModelAndView("jsp/error");
	 * model.addObject("ErrorMsg", "this is Exception.class");
	 * 
	 * return model;
	 * 
	 * }
	 */

	/**
	 * @author Aditya Created :8/10/19 Last Modified: 11/10/19 Description: Handles
	 *         exceptions inside the BRSController of type Bus Not Found
	 * @param request
	 * @param ex
	 * @return to error page
	 */

	/**
	 * @author Aditya Created: 8/10/19 Last Modified: 9/10/19 Description: redirects
	 *         to searchBuses.jsp
	 * @return searchBus.jsp
	 */
	/*
	 * @RequestMapping(value = "/searchbuses", method = RequestMethod.GET) public
	 * String searchBuses() { return "jsp/Customer/SearchBus";
	 * 
	 * }
	 */

	/**
	 * @author Aditya Created: 8/10/19 Last Modified: 9/10/19 Description: Displays
	 *         the list of all buses as ModelAndView on ShowBuses.jsp
	 * @return showbuses.jsp with List of Buses
	 */
	@RequestMapping(value = "/showbuses", method = RequestMethod.GET)
	public ModelAndView getAllData() { // admin
		List<Bus> busList = brsService.viewAllBuses();
		logger.info("Viewing the List of Buses");
		return new ModelAndView("jsp/Admin/ShowBuses", "busList", busList);
	}

	/**
	 * @author Aditya Created: 8/10/19 Last Modified: 9/10/19 Description: displays
	 *         the busTransactions according to the particular date , source and
	 *         destination
	 * 
	 * @param bus
	 * @param dateOfJourney
	 * @param dropdown
	 * @return SearchBus.jsp with List of Buses running
	 */
	@RequestMapping(value = "/showrunningbuses", method = RequestMethod.POST)
	public ModelAndView showRunningBuses(@ModelAttribute("bus") Bus bus,
			@RequestParam("date_of_journey") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dateOfJourney,
			Map<String, Object> dropdown) {
		List<String> src = brsService.findSources();
		List<String> dest = brsService.findDestinations();
		System.out.println(src);
		dropdown.put("src", src);
		dropdown.put("dest", dest);
		session.setAttribute("dateOfJourney", dateOfJourney);
		session.setAttribute("source", bus.getSource());
		session.setAttribute("destination", bus.getDestination());
		List<BusTransaction> transactionList = brsService.searchBuses(bus.getSource(), bus.getDestination(),
				dateOfJourney);
		System.out.println(transactionList);
		logger.debug("Displaying transaction list");
		return new ModelAndView("jsp/Customer/AddBooking", "transactionList", transactionList);
	}

	/**
	 * @author Aditya Created: 8/10/19 Last Modified: 9/10/19 Description: Removes
	 *         the bus from the database
	 * @param busId
	 * @return DeleteBuses.jsp
	 */
	@RequestMapping(value = "/deletebus", method = RequestMethod.GET)
	public String deleteBus(@RequestParam("busId") Integer busId) {
		try {
			brsService.removeBus(busId);
			logger.info("Deleting bus");
		} catch (BRSException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}

		return "jsp/Admin/DeleteBuses";
	}
	
	
	
	/**
	 * @author Mayank Description: shows all the users Created: 9/10/2019 Last
	 *         Modified: 9/10/2019
	 * @return jsp/Admin/ShowAllUsers
	 */
	@RequestMapping(value = "/showusers", method = RequestMethod.GET)
	public ModelAndView showAllUsers() {
		List<User> userList = brsService.viewAllUsers();

		logger.info("Listing the list of all users");
		return new ModelAndView("jsp/Admin/ShowAllUsers", "userList", userList);
	}

	

	/**
	 * 
	 * 
	 * @author Tejaswini Description: Displays the AddBooking JSP file with the
	 *         source and destination and a date picker and allows the customer to
	 *         select the source, destination and date of journey
	 * @param bus
	 * @param dropdown
	 * @return AddBooking.jsp Created On: 05/10/2019
	 */
	@RequestMapping(value = "/addbooking", method = RequestMethod.GET)
	public String addBooking(@ModelAttribute("bus") Bus bus, Map<String, Object> dropdown) {
		List<String> src = brsService.findSources();
		List<String> dest = brsService.findDestinations();
		// System.out.println(src);
		dropdown.put("src", src);
		dropdown.put("dest", dest);
		logger.info("Viewing the running buses for date: " + (LocalDate) session.getAttribute("dateOfJourney"));
		return "jsp/Customer/AddBooking";
	}

	/**
	 * @author Tejaswini Description: Redirects to AddPassenger.jsp where the
	 *         customer will add the details of the passengers
	 * @param passenger
	 * @return AddPassenger.jsp Created On: 05/10/2019
	 */
	@RequestMapping(value = "/addpassenger", method = RequestMethod.GET)
	public String addPassenger(@ModelAttribute("passenger") Passenger passenger) {
		logger.info("Adding passengers.....");
		return "jsp/Customer/AddPassenger";
	}

	/**
	 * @author Tejaswini Description: Adds the list of passengers to the particular
	 *         booking of the user session
	 * @param passenger
	 * @param result
	 * @return ModelAndView Created On: 05/10/2019
	 */
	@RequestMapping(value = "/addpassengerdetails", method = RequestMethod.POST)
	public ModelAndView addPassengerDetails(@Valid @ModelAttribute("passenger") Passenger passenger,
			BindingResult result) {
		if (result.hasErrors()) {
			return null;
		} else {

			System.out.println(passenger);
			List<Passenger> passengerList = (List<Passenger>) session.getAttribute("passengerList");
			Booking booking = (Booking) session.getAttribute("booking");
			booking.getPassengers().add(passenger);

			logger.info("Passengers for a particular booking added.");

			return new ModelAndView("jsp/Customer/AddPassenger", "passengers", passengerList);

		}
	}

	/**
	 * @author Tejaswini Description: Creates the booking for the selected date for
	 *         the customer
	 * @param busTransactionId
	 * @return Booking Created On: 05/10/2019
	 */
	@RequestMapping(value = "/createbooking", method = RequestMethod.GET)
	public ModelAndView createBooking(@RequestParam("transactionId") Integer busTransactionId) {
		BusTransaction busTransaction = brsService.viewTransactionById(busTransactionId);
		session.setAttribute("transactionId", busTransactionId);
		session.setAttribute("busId", busTransaction.getBus().getBusId());
		session.setAttribute("availableSeats", busTransaction.getAvailableSeats());
		List<BusTransaction> currentBusTransaction = new ArrayList<BusTransaction>();
		currentBusTransaction.add(busTransaction);

		logger.info("Booking initialized.....");

		Booking booking = new Booking();
		booking.setDateOfJourney((LocalDate) session.getAttribute("dateOfJourney"));
		booking.setBus(busTransaction.getBus());
		List<Passenger> passengerList = new ArrayList<Passenger>();
		booking.setPassengers(passengerList);
		session.setAttribute("passengerList", passengerList);
		session.setAttribute("booking", booking);
		System.out.println((Booking) session.getAttribute("booking"));

		return new ModelAndView("jsp/Customer/createBooking", "bus", currentBusTransaction);

	}

	/**
	 * @author Tejaswini Description: Cancels the booking selected by the user
	 * @param bookingId
	 * @return Booking Created On: 05/10/2019
	 */
	@RequestMapping(value = "/cancelbooking", method = RequestMethod.GET)
	public String cancelBooking(@RequestParam("bookingId") Integer bookingId) {
		System.out.println(bookingId);
		brsService.cancelBooking(bookingId);
		logger.info("Booking with booking id " + bookingId + " has been cancelled");
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

	/**
	 * @author Tejaswini Description: Redirects to the payment page
	 * @return payment.jsp Created On: 05/10/2019
	 */
	@RequestMapping(value = "/confirmation", method = RequestMethod.GET)
	public String confirmPayment() {
		logger.info("Redirecting to payment mode selection");
		return "jsp/Customer/payment";
	}

	/**
	 * @author Tejaswini Description: Gets the payment mode selected by the user
	 * @param paymentMode
	 * @return confirmation.jsp Created On: 05/10/2019
	 */
	@RequestMapping(value = "/pdetail", method =RequestMethod.POST)
	public String confirmBooking(@RequestParam("paymentMode") String paymentMode) {
		System.out.println("hhhhh");
		Booking booking = (Booking) session.getAttribute("booking");

		logger.info("Confirming the payment....");
		booking.setModeOfPayment(paymentMode);
		System.out.println(booking);
		return "jsp/Customer/confirmation";

	}

	/**
	 * @author Tejaswini Description: Views the current booking made by the customer
	 * @param model
	 * @return ModelAndView Created On: 05/10/2019
	 */
	@RequestMapping(value = "/viewcurrentbooking", method = RequestMethod.GET)
	public ModelAndView viewCurrentBooking(Map<String, Object> model) {

		Booking booking = (Booking) session.getAttribute("booking");

		List<Passenger> passengerList = (List<Passenger>) session.getAttribute("passengerList");
		System.out.println(passengerList);
		int passengersCount = passengerList.size();
		Integer busId = (Integer) session.getAttribute("busId");
		Bus bus = null;
		try {
			bus = brsService.viewBusById(busId);
		} catch (BRSException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage()); // error page
		}
		booking.setBookingId(booking.getBookingId());
		booking.setTotalCost(passengersCount * bus.getCostPerSeat());
		booking.setBookingStatus("BOOKED");
		User user = (User) session.getAttribute("user");
		booking.setUser(user);
		booking.setDeleteFlag(0);
		booking.setPassengers(passengerList);
		user.getBookingsList().add(booking);
		Integer busTransactionId = (Integer) session.getAttribute("transactionId");
		brsService.updateAvailableSeats(busTransactionId, passengersCount);
		List<Booking> bookings = new ArrayList<Booking>();
		bookings.add(booking);
		brsService.createBooking(booking);

		logger.info("Booking for user " + user.getUsername() + " has been made successfully");

		model.put("passengers", passengerList);
		return new ModelAndView("jsp/Customer/currentBooking", "bookings", bookings);

	}

	/*
	 * @RequestMapping(value = "/cancelcurrentbooking", method = RequestMethod.GET)
	 * public String cancelCurrentBooking() { Booking booking = (Booking)
	 * session.getAttribute("booking");
	 * brsService.cancelBooking(booking.getBookingId()); return
	 * "jsp/Customer/CancelBooking"; }
	 */

	/**
	 * @author Tejaswini Description: List all the bookings made till date by the
	 *         customer
	 * @return ModelAndView Created On: 05/10/2019
	 */
	@RequestMapping(value = "/viewallbookings", method = RequestMethod.GET)
	public ModelAndView viewAllBookings() {
		User user = (User) session.getAttribute("user");
		List<Booking> bookingsList = brsService.viewAllBookings(user);
		System.out.println(bookingsList);

		logger.info("Listing the list of all bookings of user " + user.getUsername());
		return new ModelAndView("jsp/Customer/ViewBookings", "bookings", bookingsList);
	}

	
}
