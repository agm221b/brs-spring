package com.cg.brs.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.brs.dto.Booking;
import com.cg.brs.dto.Bus;
import com.cg.brs.dto.BusTransaction;
import com.cg.brs.dto.Passenger;
import com.cg.brs.dto.User;

public interface BRSService {

	public Bus addBusDetails(Bus bus);
	public Integer removeBus(Integer busId);
	public List<Bus> viewAllBuses();
	public Bus viewBusById(Integer busId);
	public List<Object[]> viewBusByRoutes(String source,String destination);
	
	
	public Booking createBooking(Booking booking);
	public Integer removeBooking(Integer bookingId);
	public List<Booking> viewAllBookings();
	
	public BusTransaction addTransaction(BusTransaction transaction);
	public List<BusTransaction> viewAllTransactions();
	public List<BusTransaction> viewTransactionsByDate(LocalDate date);
	public BusTransaction viewTransactionById(Integer busTransactionId);
	public BusTransaction updateTransaction(Integer busTransactionId);
	
	public List<BusTransaction> searchBuses(String source, String destination, LocalDate dateOfJourney);
	
	
	public User addUser(User user);
	public Integer removeCustomer(Integer customerId);
	public List<User> viewAllUsers();
	public User validateUser(String username, String password);
	
	public Passenger addPassenger(Passenger passenger);
	
}
