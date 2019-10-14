package com.cg.BRSSpringRest.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.BRSSpringRest.dto.Booking;
import com.cg.BRSSpringRest.dto.Bus;
import com.cg.BRSSpringRest.dto.BusTransaction;
import com.cg.BRSSpringRest.dto.User;
import com.cg.BRSSpringRest.exception.BRSException;
import com.cg.BRSSpringRest.exception.BRSException;

public interface BRSService {

	public Bus addBusDetails(Bus bus) throws BRSException;

	public Integer removeBus(Integer busId) throws BRSException;

	public List<Bus> viewAllBuses();

	public Bus viewBusById(Integer busId) throws BRSException;

	public List<Bus> viewBusByRoutes(String source, String destination);

	public List<String> findSources();

	public List<String> findDestinations();

	public Booking createBooking(Booking booking);

	public Booking cancelBooking(Integer bookingId);

	public List<Booking> viewAllBookings(User user);

	public Booking findBookingById(Integer bookingId);

	public BusTransaction addTransaction(BusTransaction transaction);

	public List<BusTransaction> viewAllTransactions();

	public List<BusTransaction> viewTransactionsByDate(LocalDate date);

	public BusTransaction viewTransactionById(Integer busTransactionId);

	public BusTransaction updateAvailableSeats(Integer busTransactionId, Integer passengersCount);

	public List<BusTransaction> searchBuses(String source, String destination, LocalDate dateOfJourney);

	public User addUser(User user);

	public Integer removeUser(Integer userId) throws BRSException;

	public List<User> viewAllUsers();

	public User validateUser(String username, String password) throws BRSException;

	public User findUserByName(String username);

	public User findUserById(Integer userId);

	/* public Passenger addPassenger(Passenger passenger); */

}
