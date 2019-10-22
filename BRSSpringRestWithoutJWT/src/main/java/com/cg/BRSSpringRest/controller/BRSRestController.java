package com.cg.BRSSpringRest.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin(origins = "http://localhost:4200")
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
			@ModelAttribute Booking booking) {
		BusTransaction busTransaction = brsService.viewTransactionById(busTransactionId);
		booking.setBus(busTransaction.getBus());
		booking.setBookingStatus("BOOKED");
		booking.setModeOfPayment(booking.getModeOfPayment());
		booking.setUser(booking.getUser());
		booking.setDeleteFlag(0);
		booking.setDateOfJourney(busTransaction.getDate());
		booking.setUser(brsService.findName("tejaswini"));
		
		booking.setPassengers(booking.getPassengers());
		booking.setTotalCost(booking.getPassengers().size()*busTransaction.getBus().getCostPerSeat());
		booking.setDeleteFlag(0);
		
		brsService.updateAvailableSeats(busTransactionId, booking.getPassengers().size());
		return brsService.createBooking(booking);
	}

	@GetMapping(value = "/viewallbookings")
	public List<Booking> viewAllBookings() {
		User user = brsService.findName("tejaswini");
		return brsService.viewAllBookings(user);
	}
	
	
	@GetMapping(value="/viewbooking")
	public Booking viewBookingById(@RequestParam(value = "bookingId")Integer bookingId) {
		return brsService.findBookingById(bookingId);
	}

	@PutMapping(value = "/cancelbooking")
	public Booking cancelBooking(@RequestParam(value="bookingId")Integer bookingId) {
		System.out.println(bookingId);
		return brsService.cancelBooking(bookingId);
	}

	@PostMapping(value = "/addbusdetails")
	public Bus addBusDetails(@ModelAttribute Bus bus) throws BRSException {
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
	
	/**
	 * 
	 * @author Aditya Created: 13/10/19 Last Modified: 13/10/19 
	 * Description: Displays the list of all buses as List
	 * @return List of Buses which have deleteFlag as 0
	 */
	@GetMapping(value = "/showbuses")
	public List<Bus> getAllData() { // admin
		List<Bus> busList = brsService.viewAllBuses();
		logger.info("Viewing the List of Buses");
		return busList;
	}


	/**
	 * Aditya Created: 13/10/19 Last Modified: 13/10/19 
	 * Description: Deletes the bus with the particular busId
	 * @param busId
	 * @return String of the status of the bus,whether deleted or not.
	 */
	@PutMapping(value = "/deletebus")
	public String deleteBus(@RequestParam("busId") Integer busId) {
		String status = null;
		try {
			if (brsService.removeBus(busId) == 1) {

				logger.info("Deleted bus");
				status= "Deleted Bus";
			}
			else
			{
				logger.info("Could not delete bus");
				status= "Could not delete bus";
			}
		} catch (BRSException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}

		return status;
	}
	
	/**
	 * @author Mayank Description: adds user
	 *  Created: 12/10/2019 
	 *  Last Modified:12/10/2019
	 * @return User response entity
	 */
	@PostMapping(value="/adduser")
	public ResponseEntity<User> addData(@ModelAttribute User user){
		List<Booking> bookingsList=new ArrayList<Booking>();
		user.setBookingsList(bookingsList);
		user=brsService.addUser(user);
		if (user==null) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
		return new ResponseEntity<User>(user,HttpStatus.OK);
		}}
	
		
	
	
	/**
	 * @author Mayank Description: shows all the users Created: 12/10/2019 Last
	 *         Modified: 12/10/2019
	 * @return List of Users
	 */
	@GetMapping(value="/showusers")
	public ResponseEntity<List<User>> showAllUsers(){
		List<User> userList = brsService.viewAllUsers();
		if (userList.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
		}}
	

	/**
	 * @author Mayank Description: removes user
	 *  Created: 13/10/2019 
	 *  Last Modified:13/10/2019
	 * @return true if user gets removed
	 */
	@PutMapping(value="/removeuser")
	public boolean removeUser(@RequestParam Integer userId) throws Exception {
		User user= brsService.findUserById(userId);
		if(user==null)
			throw new Exception("User not found with Id: "+userId);
		brsService.removeUser(userId);
		return true;
	}
	
	
	@GetMapping(value="/getsources")
	public List<String> getSourceList(){
		return brsService.findSources();
	}
	
	@GetMapping(value="/getdestinations")
	public List<String> getDestinationList(){
		return brsService.findDestinations();
	}
	
	@GetMapping(value="/showrunningbuses")
	public List<BusTransaction> showRunningBuses(@RequestParam(value = "source") String source,
			@RequestParam(value = "destination") String destination,@RequestParam("journeydate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dateOfJourney){
		System.out.println(destination+" "+dateOfJourney+" "+source);
		System.out.println(brsService.searchBuses(source, destination, dateOfJourney));
		return brsService.searchBuses(source, destination, dateOfJourney);
	}
}
	
