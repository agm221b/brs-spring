package com.cg.BRSSpringRest.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.BRSSpringRest.dto.Booking;
import com.cg.BRSSpringRest.dto.Bus;
import com.cg.BRSSpringRest.dto.BusTransaction;
import com.cg.BRSSpringRest.dto.Passenger;
import com.cg.BRSSpringRest.dto.User;
import com.cg.BRSSpringRest.exception.BRSException;
import com.cg.BRSSpringRest.service.BRSService;

/**
 * @author Aditya, Mayank, Tejaswini
 * Description: REST controller for the bus reservation system
 * Created on: 09/10/2019
 * Last Modified: 09/10/2019 10:37 AM
 *
 */
/**
 * @author OSIS11
 *
 */
@RestController
@RequestMapping(value = "/brs")
public class BRSRestController {

	private static final Logger logger = LoggerFactory.getLogger(BRSRestController.class);

	@Autowired
	BRSService brsService;

	HttpSession session;

	/**
	 * @author Tejaswini Description: Adds the current booking to the booking table
	 * @param Booking
	 * @return Booking Created On: 09/10/2019 Last Modified: 09/10/2019 10:53 AM
	 */

	@PostMapping(value = "/createbooking")
	public Booking addBooking(@RequestParam(value = "busTransactionId") Integer busTransactionId,
			@RequestBody Booking booking) {
		BusTransaction busTransaction = brsService.viewTransactionById(busTransactionId);
		booking.setBus(busTransaction.getBus());
		booking.setDateOfJourney(busTransaction.getDate());
		booking.setUser(null);
		List<Passenger> passengers = new ArrayList<Passenger>();

		Passenger passenger1 = new Passenger();
		passenger1.setPassengerName("tejaswini");
		passenger1.setPassengerAge(20);
		passenger1.setPassengerGender('F');
		passengers.add(passenger1);

		Passenger passenger2 = new Passenger();
		passenger2.setPassengerName("tejaswini");
		passenger2.setPassengerAge(20);
		passenger2.setPassengerGender('F');
		passengers.add(passenger2);

		booking.getPassengers().add(passenger1);
		booking.getPassengers().add(passenger2);
		return brsService.createBooking(booking);
	}

	@GetMapping(value = "/viewallbookings")
	public List<Booking> viewAllBookings() {
		User user = (User) session.getAttribute("user");
		return brsService.viewAllBookings(user);
	}

	@PutMapping(value = "/cancelbooking")
	public Booking cancelBooking(Integer bookingId) {
		return brsService.cancelBooking(bookingId);
	}

	@PostMapping(value = "/addbusdetails")
	public Bus addBusDetails(@RequestBody Bus bus) throws BRSException {
		System.out.println("bus " + bus);
		Bus busAdd = null;

		try {
			busAdd = brsService.addBusDetails(bus);
		} catch (BRSException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}

		for (int i = 1; i < 15; i++) {
			BusTransaction busTransaction = new BusTransaction();
			busTransaction.setDate(LocalDate.now().plusDays(i));
			busTransaction.setBus(bus);
			busTransaction.setAvailableSeats(bus.getNoOfSeats());
			busTransaction.setDeleteFlag(0);
			brsService.addTransaction(busTransaction);
		}

		return busAdd;

	}

	@GetMapping(value = "/home")
	public String homePage() {
		return "Home";
	}

}
