package com.cg.brs.dao;

import java.time.LocalDate;
import java.util.List;

import com.cg.brs.dto.Booking;
import com.cg.brs.dto.Bus;
import com.cg.brs.dto.BusTransaction;
import com.cg.brs.dto.User;
import com.cg.brs.dto.Passenger;

public interface BRSDao {

	public Bus saveBus(Bus bus);
	public Integer removeBus(Integer busId);
	public List<Bus> findAllBuses();
	public List<Object[]> findBusByRoutes(String source, String destination);
	public Bus findBusById(Integer busId);
	
	
	public Booking saveBooking(Booking booking);
	public Integer removeBooking (Integer booking);
	public Booking findBookingById(Integer booking);
	public List<Booking> findAllBookings();
	
	public List<Passenger> findAllPassengers(Integer bookingId);
	
	public BusTransaction saveTransaction(BusTransaction busTransaction);
	public List<BusTransaction> findAllTransactions();
	public BusTransaction findTransactionById(Integer transactionId);
	public BusTransaction updateTransaction(Integer transactionId);
	public List<BusTransaction> findTransactionsByDate(LocalDate date);
	
//	public BusTransaction insertBookingIntoTransaction(Booking booking, BusTransaction busTransaction);
	
	public User saveUser(User user);
	public Integer removeUser(Integer customerId);
	public List<User> viewAllUsers();
}
