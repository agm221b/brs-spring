package com.cg.BrsSpringBootMVC.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.BrsSpringBootMVC.dao.BookingRepository;
import com.cg.BrsSpringBootMVC.dao.BusRepository;

import com.cg.BrsSpringBootMVC.dao.BusTransactionRepository;
import com.cg.BrsSpringBootMVC.dao.UserRepository;
import com.cg.BrsSpringBootMVC.dto.Booking;
import com.cg.BrsSpringBootMVC.dto.Bus;
import com.cg.BrsSpringBootMVC.dto.BusTransaction;
import com.cg.BrsSpringBootMVC.dto.User;
import com.cg.BrsSpringBootMVC.exception.BRSException;


/**
 * @author Aditya, Tejaswini, Mayank
 * Created: 8/10/19
 * Last Modified: 9/10/19
 * Description: This is the BRS Service that calls the various Repositories and performs various service operations
 *
 */
@Service("brsService")
@Transactional
public class BRSServiceImpl implements BRSService {

	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	BusTransactionRepository busTransactionRepository;
	@Autowired
	BusRepository busRepository;
	@Autowired
	UserRepository userRepository;

	/**
	 * @author Aditya
	 * Created: 8/10/19
	 * Last Modified: 9/10/19
	 * Description: Adds the bus into the Repository
	 * @param bus
	 * @return bus that is added
	 */
	@Override
	public Bus addBusDetails(Bus bus) { // TODO Auto-generated method
		return busRepository.save(bus);
	}

	/**
	 * @author Aditya
	 * Created: 8/10/19
	 * Last Modified: 9/10/19
	 * Description: Removes the bus from the Repository
	 * @param busId
	 *	@return 0 if bus is already deleted or does not exist, 1 if it is removed 
	 */
	@Override
	public Integer removeBus(Integer busId) { // TODO Auto-generated
		Bus bus = busRepository.findByBusIdAndDeleteFlag(busId, 0);
		if (bus == null)
			return 0;
		else
			bus.setDeleteFlag(1);
		busRepository.save(bus);
		return 1;
	}
	/**
	 * @author Aditya
	 * Created: 8/10/19
	 * Last Modified: 9/10/19
	 * Description: Views all the buses from the Repository
	 *@return List of all buses with deleteFlag as 0.
	 */
	@Override
	public List<Bus> viewAllBuses() { // TODO Auto-generated method
		return busRepository.findByDeleteFlag(0);
	}

	/**
	 * @author Aditya
	 * Created: 8/10/19
	 * Last Modified: 9/10/19
	 * Description: Views the bus with that particular busId from the Repository
	 * @param busId
	 *@return bus with that busId
	 */
	@Override
	public Bus viewBusById(Integer busId) { // TODO Auto-generated
		return busRepository.findByBusIdAndDeleteFlag(busId, 0);
	}

	/**
	 * @author Aditya
	 * Created: 8/10/19
	 * Last Modified: 9/10/19
	 * Description: Views the Bus with those particular sources and destinations
	 * @param source
	 * @param destination
	 *@return List of buses with particular sources and destinations
	 */
	@Override
	public List<Bus> viewBusByRoutes(String source, String destination) { // TODO Auto-generated method stub return
		return (List<Bus>) busRepository.findBySourceAndDestinationAndDeleteFlag(source, destination, 0);

	}

	/**
	 * @author Aditya
	 * Created: 8/10/19
	 * Last Modified: 9/10/19
	 * Description: Find the list of all the sources in database
	 *@return list of sources of all the buses in the database
	 */
	@Override
	public List<String> findSources() { // TODO Auto-generated method stub


		return busRepository.findBySource();
	}

	/**
	 * @author Aditya
	 * Created: 8/10/19
	 * Last Modified: 9/10/19
	 * Description: Find the list of all destinations in the database
	 *@return list of destinations of all the buses in the database
	 */
	@Override
	public List<String> findDestinations() { // TODO Auto-generated method stub

		return busRepository.findByDestination();
	}

	/**
	 * @author Tejaswini
	 * Description: save the current booking data
	 * @param booking
	 * @return booking
	 * Created On : 06/10/2019
	 */
	@Override
	public Booking createBooking(Booking booking) {
		// TODO Auto-generated method stub
		booking.setBus(booking.getBus());
		booking.setPassengers(booking.getPassengers());
		booking.setUser(booking.getUser());
		return bookingRepository.save(booking);
	}

	/**
	 * @author Tejaswini
	 * Description: sets the booking status to CANCELLED of the selected booking object
	 * @param bookingId
	 * @return booking
	 * Created On : 06/10/2019
	 */
	@Override
	public Booking cancelBooking(Integer bookingId) {
		// TODO Auto-generated method stub
		Booking booking = bookingRepository.findById(bookingId).get();
		booking.setBookingStatus("CANCELLED");
		return booking;
	}

	/**
	 * @author Tejaswini
	 * Description: gets the list of the bookings made by a particular user
	 * @param user
	 * @return List<Booking>
	 * Created On : 06/10/2019
	 */
	@Override
	public List<Booking> viewAllBookings(User user) {
		// TODO Auto-generated method stub
		return bookingRepository.findByUser(user);
	}


	/**
	 * @author Tejaswini
	 * Description: finds the booking on the selected booking id
	 * @param bookingId
	 * @return booking
	 * Created On : 06/10/2019
	 */
	@Override
	public Booking findBookingById(Integer bookingId) {
		// TODO Auto-generated method stub
		return bookingRepository.findById(bookingId).get();
	}

	/**
	 * save the transaction of the bus
	 *@param busTransaction
	 *@return busTransaction
	 */
	@Override
	public BusTransaction addTransaction(BusTransaction transaction) {
		return busTransactionRepository.save(transaction);
	}


	/**
	 *lists all the transactions of all the buses
	 */
	@Override 
	public List<BusTransaction> viewAllTransactions() { 
		return busTransactionRepository.findAll();
	}

	/**
	 * lists the transactions of the buses based on the selected date
	 *@param dateOfJourney
	 *@return List<BusTransaction>
	 */
	@Override 
	public List<BusTransaction> viewTransactionsByDate(LocalDate date){
		// TODO Auto-generated method stub return
		return busTransactionRepository.findByDate(date);

	}

	/**
	 * fetches the details of the transaction based on the id
	 *@param busTransactionId
	 *@return busTransaction
	 */
	@Override 
	public BusTransaction viewTransactionById(Integer busTransactionId){
		// TODO Auto-generated method stub return
		return busTransactionRepository.findById(busTransactionId).get();
	}


	/**
	 * returns the list of buses along with their available seats on the selected date of journey
	 *@param source,destination,dateOfJourney
	 *@return List<BusTransaction>
	 */
	@Override 
	public List<BusTransaction> searchBuses(String source, String destination, LocalDate dateOfJourney) {
		List<BusTransaction> transactionsByRoutes=new ArrayList<BusTransaction>();
		for(BusTransaction busTransaction:viewTransactionsByDate(dateOfJourney)) {
			if(busTransaction.getDate().equals(dateOfJourney)) {
				if(busTransaction.getBus().getSource().equalsIgnoreCase(source) && busTransaction.getBus().getDestination().equalsIgnoreCase(destination)) {
					transactionsByRoutes.add(busTransaction);
				}
			}
		}
		return transactionsByRoutes;
	}


	/**
	 * updates the count of the available seats in the bus
	 * @param busTransactionId,passengersCount
	 * @return busTransaction
	 */
	@Override
	public BusTransaction updateAvailableSeats(Integer busTransactionId, Integer passengersCount) {
		BusTransaction busTransaction = viewTransactionById(busTransactionId);
		busTransaction.setAvailableSeats(busTransaction.getAvailableSeats() - passengersCount);
		return busTransaction;
	}

	/**
	 * @author Mayank
	 * Description: method to add user
	 * Created: 9/10/2019
	 * Last Modified: 9/10/2019
	 * @param user
	 * @return user that is added
	 */
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
	/**
	 * @author Mayank
	 * Description: method to delete user, input is userId
	 * Created: 9/10/2019
	 * Last Modified: 9/10/2019
	 * @param userId
	 * @return 0 if user is already deleted or does not exist, 1 if it is removed 
	 * @throws BRSException 
	 */
	@Override
	public Integer removeUser(Integer userId) throws BRSException {
		// TODO Auto-generated method stub return
		User user = userRepository.findByUserIdAndDeleteFlag(userId, 0);
		if (user == null)
			throw new BRSException(" user not found for deletion");
		else
			user.setDeleteFlag(1);
			userRepository.save(user);
			return 1;

	}
	/**
	 * @author Mayank
	 * Description: method to view all the users
	 * Created: 9/10/2019
	 * Last Modified: 9/10/2019
	 * @return lists all the users of all the buses
	 */
	@Override
	public List<User> viewAllUsers() {
		// TODO Auto-generated method
		return userRepository.findAll();
	}

	/**
	 * @author Mayank
	 * Description: method to validate user
	 * Created: 9/10/2019
	 * Last Modified: 9/10/2019
	 * @param username
	 * @param password
	 * @return user after validating given username and password
	 * @throws BRSException 
	 */
	@Override
	public User validateUser(String username, String password) throws BRSException {
		// TODO Auto-generated
		/*
		 * List<User> userList=userRepository.findAll(); for (User user: userList) { if
		 * (user.getUsername().equals(username) && user.getPass().equals(password)) {
		 * return user; } else { return null; } } return ;
		 */
		User user = userRepository.findByUsernameAndPass(username, password);
		if (user == null)
			throw new BRSException("User not found");
		
			return user;
	}

}
