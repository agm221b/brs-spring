package com.cg.BRSSpringRest.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.BRSSpringRest.dto.Booking;
import com.cg.BRSSpringRest.dto.Bus;
import com.cg.BRSSpringRest.dto.User;
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
	
	@Autowired
	BRSService brsService;
	
	HttpSession session;
	
	
	
	/**@author Tejaswini
	 * Description: Adds the current booking to the booking table
	 * @param Booking
	 * @return Booking
	 * Created On: 09/10/2019
	 * Last Modified: 09/10/2019 10:53 AM
	 */
	@PostMapping(value = "/createbooking")
	public Booking addBooking(@RequestParam(value = "busId")Integer busId,@RequestBody Booking booking) {
		Bus bus=brsService.viewBusById(busId);
		booking.setBus(bus);
		booking.setUser(null);
		booking.setPassengers(null);
		return brsService.createBooking(booking);
	}
	
	@GetMapping(value="/viewallbookings")
	public List<Booking> viewAllBookings() {
		User user=(User)session.getAttribute("user");
		return brsService.viewAllBookings(user);
	}
	
	@PutMapping(value="/cancelbooking")
	public Booking cancelBooking(Integer bookingId) {
		return brsService.cancelBooking(bookingId);
	}
	
	
	
	
	
	
	
	

}
