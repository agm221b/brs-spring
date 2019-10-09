package com.cg.BrsSpringBootMVC.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.BrsSpringBootMVC.dto.Booking;
import com.cg.BrsSpringBootMVC.dto.Bus;
import com.cg.BrsSpringBootMVC.dto.BusTransaction;
import com.cg.BrsSpringBootMVC.dto.Passenger;
import com.cg.BrsSpringBootMVC.dto.User;
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

	private static final Logger logger = LogManager.getLogger(BRSController.class);

	/**
	 * directs to the home page of the web site
	 * 
	 * @return jsp/home
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHomePage() {
		logger.debug("In Home now");
		return "jsp/home";
	}

	/**
	 * directs to the home page of the admin
	 * 
	 * @return jsp/Admin/AdminHome
	 */
	@RequestMapping(value = "/adminhome", method = RequestMethod.GET)
	public String viewAdminHome() {
		logger.debug("In Admin Home now");
		return "jsp/Admin/AdminHome";

	}

	/**
	 * directs to the home page of the customer
	 * 
	 * @return jsp/Customer/CustomerHome
	 */
	@RequestMapping(value = "/customerhome", method = RequestMethod.GET)
	public String viewCustomerHome() {
		return "jsp/Customer/CustomerHome";

	}

	/**
	 * directs to the login page. Common for both admin and customer
	 * 
	 * @return jsp/login
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "jsp/login";
	}

	/**
	 * validates the login credentials
	 * 
	 * @param username
	 * @param password
	 * @param model
	 * @param session
	 * @return
	 */
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

	/**
	 * @param session
	 * @return
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
	 */
	@RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
	public String showAboutUsPage() {
		return "jsp/aboutUs";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterPage(@ModelAttribute("user") User user) {
		return "jsp/register";
	}

	/**
	 * @author Mayank
	 * Description: adds user and redirects to home.jsp page or redirects to register.jsp page
	 * Created: 9/10/2019
	 * Last Modified: 9/10/2019
	 * @return jsp/home
	 */
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
		return "jsp/help";
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
	 */
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

	/**
	 * @author Aditya Created: 8/10/19 Last Modified: 9/10/19 Description: redirects
	 *         to searchBuses.jsp
	 * @return searchBus.jsp
	 */
	@RequestMapping(value = "/searchbuses", method = RequestMethod.GET)
	public String searchBuses() {
		return "jsp/Customer/SearchBus";

	}

	/**
	 * @author Aditya Created: 8/10/19 Last Modified: 9/10/19 Description: Displays
	 *         the list of all buses as ModelAndView on ShowBuses.jsp
	 * @return showbuses.jsp with List of Buses
	 */
	@RequestMapping(value = "/showbuses", method = RequestMethod.GET)
	public ModelAndView getAllData() { // admin
		List<Bus> busList = brsService.viewAllBuses();
		return new ModelAndView("jsp/Admin/ShowBuses", "busList", busList);
	}

	/**
	 * @author Aditya Created: 8/10/19 Last Modified: 9/10/19 Description: displays
	 *         the busTransactions according to the particular date , source and
	 *         destination
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
		return new ModelAndView("jsp/Customer/SearchBus", "transactionList", transactionList);
	}

	/**
	 * @author Aditya Created: 8/10/19 Last Modified: 9/10/19 Description: Removes
	 *         the bus from the database
	 * @param busId
	 * @return DeleteBuses.jsp
	 */
	@RequestMapping(value = "/deletebus", method = RequestMethod.GET)
	public String deleteBus(@RequestParam("busId") Integer busId) {
		brsService.removeBus(busId);

		return "jsp/Admin/DeleteBuses";
	}

	/**
<<<<<<< HEAD
	 * @author Tejaswini
	 * Description: Displays the AddBooking JSP file with the source and destination and a date picker
	 * and allows the customer to select the source, destination and date of journey
=======
	 * 
>>>>>>> branch 'master' of https://github.com/agm221b/brs-spring.git
	 * @param bus
	 * @param dropdown
	 * @return AddBooking.jsp
	 * Created On: 05/09/2019
	 */
	@RequestMapping(value = "/addbooking", method = RequestMethod.GET)
	public String addBooking(@ModelAttribute("bus") Bus bus, Map<String, Object> dropdown) {
		List<String> src = brsService.findSources();
		List<String> dest = brsService.findDestinations();
		// System.out.println(src);
		dropdown.put("src", src);
		dropdown.put("dest", dest);
		return "jsp/Customer/AddBooking";
	}

	/**@author Tejaswini
	 * Description: Redirects to AddPassenger.jsp where the customer will add the details of the passengers 
	 * @param passenger
	 * @return AddPassenger.jsp
	 * Created On: 05/09/2019
	 */
	@RequestMapping(value = "/addpassenger", method = RequestMethod.GET)
	public String addPassenger(@ModelAttribute("passenger") Passenger passenger) {
		return "jsp/Customer/AddPassenger";
	}

	/**@author Tejaswini
	 * Description: Adds the list of passengers to the particular booking of the user session
	 * @param passenger
	 * @param result
	 * @return ModelAndView
	 * Created On: 05/09/2019
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
			passengerList.add(passenger);
			booking.setPassengers(passengerList);

			return new ModelAndView("jsp/Customer/AddPassenger", "passengers", passengerList);

		}
	}

	/**
	 * @author Tejaswini
	 * Description: Creates the booking for the selected date for the customer
	 * @param busTransactionId
	 * @return Booking
	 * Created On: 05/09/2019
	 */
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

	/**@author Tejaswini
	 * Description: Cancels the booking selected by the user
	 * @param bookingId
	 * @return Booking
	 * Created On: 05/09/2019
	 */
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
	
	
	/**@author Tejaswini
	 * Description: Redirects to the payment page
	 * @return payment.jsp
	 * Created On: 05/09/2019
	 */
	@RequestMapping(value = "/confirmation", method = RequestMethod.GET)
	public String confirmPayment() {
		return "jsp/Customer/payment";
	}
	
	
	/**
	 * @author Tejaswini
	 * Description: Gets the payment mode selected by the user
	 * @param paymentMode
	 * @return confirmation.jsp
	 * Created On: 05/09/2019
	 */
	@RequestMapping(value = "/paymentdetails", method = RequestMethod.POST)
	public String confirmBooking(@RequestParam("paymentMode") String paymentMode) {
		Booking booking = (Booking) session.getAttribute("booking");
		booking.setModeOfPayment(paymentMode);
		System.out.println(booking);
		return "jsp/Customer/confirmation";

	}

	/**
	 * @author Tejaswini
	 * Description: Views the current booking made by the customer
	 * @param model
	 * @return ModelAndView
	 * Created On: 05/09/2019
	 */
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
		user.getBookingsList().add(booking);
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

	/**
	 * @author Tejaswini
	 * Description: List all the bookings made till date by the customer
	 * @return ModelAndView
	 * Created On: 05/09/2019
	 */
	@RequestMapping(value = "/viewallbookings", method = RequestMethod.GET)
	public ModelAndView viewAllBookings() {
		User user = (User) session.getAttribute("user");
		List<Booking> bookingsList = brsService.viewAllBookings(user);
		System.out.println(bookingsList);
		return new ModelAndView("jsp/test", "bookings", bookingsList);
	}


	/**
	 * @author Mayank
	 * Description: shows all the users
	 * Created: 9/10/2019
	 * Last Modified: 9/10/2019
	 * @return jsp/Admin/ShowAllUsers
	 */
	@RequestMapping(value = "/showusers", method = RequestMethod.GET)
	public ModelAndView showAllUsers() {
		List<User> userList = brsService.viewAllUsers();
		return new ModelAndView("jsp/Admin/ShowAllUsers", "userList", userList);
	}

}
