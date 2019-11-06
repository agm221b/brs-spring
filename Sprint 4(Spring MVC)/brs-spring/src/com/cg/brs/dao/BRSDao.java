package com.cg.brs.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.cg.brs.dto.Booking;
import com.cg.brs.dto.Bus;
import com.cg.brs.dto.BusTransaction;
import com.cg.brs.dto.Passenger;
import com.cg.brs.dto.User;

public interface BRSDao {

	public Bus saveBus(Bus bus);
	public Integer removeBus(Integer busId);
	public List<Bus> findAllBuses();
	public List<Object[]> findBusByRoutes(String source, String destination);
	public Bus findBusById(Integer busId);
	
	public List<String> findSrc();
	public List<String> findDest();
	
	
	public Booking saveBooking(Booking booking);
	public Integer removeBooking (Integer bookingId);
	public Booking findBookingById(Integer bookingId);
	public List<Booking> findAllBookings();
	
	public Passenger savePassenger(Passenger passenger);
	
	public List<Passenger> findAllPassengers(Integer bookingId);
	
	public BusTransaction saveTransaction(BusTransaction busTransaction);
	public List<BusTransaction> findAllTransactions();
	public BusTransaction findTransactionById(Integer transactionId);
	public BusTransaction updateAvailableSeats(Integer transactionId,Integer passengerCount);
	public List<BusTransaction> findTransactionsByDate(LocalDate date);
	
//	public BusTransaction insertBookingIntoTransaction(Booking booking, BusTransaction busTransaction);
	
	public User saveUser(User user);
	public Integer removeUser(Integer userId);
	public List<User> viewAllUsers();
	public User validateUser(String username, String password);
	
	public List<BusTransaction> searchBuses(String source,String destination,LocalDate dateOfJourney);
}
