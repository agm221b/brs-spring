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

/**
 * @author Aditya, Tejaswini
 *
 */
/**
 * @author HARIBABU
 *
 */
/**
 * @author HARIBABU
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
	 * @param bus
	 * @return bus that is added
	 */
	@Override
	public Bus addBusDetails(Bus bus) { // TODO Auto-generated method
		return busRepository.save(bus);
	}

	/**
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
	 *@return List of all buses with deleteFlag as 0.
	 */
	@Override
	public List<Bus> viewAllBuses() { // TODO Auto-generated method
		return busRepository.findByDeleteFlag(0);
	}

	/**
	 * @param busId
	 *@return bus with that busId
	 */
	@Override
	public Bus viewBusById(Integer busId) { // TODO Auto-generated
		return busRepository.findByBusIdAndDeleteFlag(busId, 0);
	}

	/**
	 * @param source
	 * @param destination
	 *@return List of buses with particular sources and destinations
	 */
	@Override
	public List<Bus> viewBusByRoutes(String source, String destination) { // TODO Auto-generated method stub return
		return (List<Bus>) busRepository.findBySourceAndDestinationAndDeleteFlag(source, destination, 0);

	}

	/**
	 *@return list of sources of all the buses in the database
	 */
	@Override
	public List<String> findSources() { // TODO Auto-generated method stub
		

		return busRepository.findBySource();
	}

	/**
	 *@return list of destinations of all the buses in the database
	 */
	@Override
	public List<String> findDestinations() { // TODO Auto-generated method stub

		return busRepository.findByDestination();
	}

	/**
	 * save the current booking data
	 *@param booking
	 *@return booking
	 */
	@Override
	public Booking createBooking(Booking booking) {
		// TODO Auto-generated method stub
		return bookingRepository.save(booking);
	}

	/**
	 * sets the booking status to CANCELLED of the selected booking object
	 *@param bookingId
	 *@return booking
	 */
	@Override
	public Booking cancelBooking(Integer bookingId) {
		// TODO Auto-generated method stub
		Booking booking = bookingRepository.findById(bookingId).get();
		booking.setBookingStatus("CANCELLED");
		return booking;
	}

	/**
	 * gets the list of the bookings made by a particular user
	 *@param user
	 *@return List<Booking>
	 */
	@Override
	public List<Booking> viewAllBookings(User user) {
		// TODO Auto-generated method stub
		return bookingRepository.findByUser(user);
	}
	
	
	/**
	 *finds the booking on the selected booking id
	 *@param bookingId
	 *@return booking
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
	 * @param user
	 * @return user that is added
	 */
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	/**
	 * @param userId
	 *	@return 0 if user is already deleted or does not exist, 1 if it is removed 
	 */
	@Override
	public Integer removeUser(Integer userId) {
		// TODO Auto-generated method stub return
		User user = userRepository.findByUserIdAndDeleteFlag(userId, 0);
		if (user == null)
			return 0;
		else
			user.setDeleteFlag(1);
		userRepository.save(user);
		return 1;
		
	}

	 /**
	 *lists all the users of all the buses
	 */
	@Override
	public List<User> viewAllUsers() {
		// TODO Auto-generated method
		return userRepository.findAll();
	}

	/**
	 * @param username
	 * @param password
	 *@return user after validating given username and password
	 */
	@Override
	public User validateUser(String username, String password) {
		// TODO Auto-generated
		/*
		 * List<User> userList=userRepository.findAll(); for (User user: userList) { if
		 * (user.getUsername().equals(username) && user.getPass().equals(password)) {
		 * return user; } else { return null; } } return ;
		 */
		User user = userRepository.findByUsernameAndPass(username, password);
		if (user == null)
			return null;
		else
			return user;
	}

}
