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
import com.cg.BrsSpringBootMVC.dto.Booking;
import com.cg.BrsSpringBootMVC.dto.Bus;
import com.cg.BrsSpringBootMVC.dto.BusTransaction;
import com.cg.BrsSpringBootMVC.dto.User;

/**
 * @author Aditya, Tejaswini
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
		List<String> sources = new ArrayList<String>();
		for (Bus bus : busRepository.findByDeleteFlag(0)) {
			sources.add(bus.getSource());
		}

		return sources;
	}

	/**
	 *@return list of destinations of all the buses in the database
	 */
	@Override
	public List<String> findDestinations() { // TODO Auto-generated method stub
		List<String> destinations = new ArrayList<String>();
		for (Bus bus : busRepository.findByDeleteFlag(0)) {
			destinations.add(bus.getDestination());
		}

		return destinations;
	}

	@Override
	public Booking createBooking(Booking booking) {
		// TODO Auto-generated method stub
		return bookingRepository.save(booking);
	}

	@Override
	public Booking cancelBooking(Integer bookingId) {
		// TODO Auto-generated method stub
		Booking booking = bookingRepository.findById(bookingId).get();
		booking.setBookingStatus("CANCELLED");
		return booking;
	}

	@Override
	public List<Booking> viewAllBookings() {
		// TODO Auto-generated method stub
		return bookingRepository.findAll();
	}

	@Override
	public Booking findBookingById(Integer bookingId) {
		// TODO Auto-generated method stub
		return bookingRepository.findById(bookingId).get();
	}

	@Override
	public BusTransaction addTransaction(BusTransaction transaction) {
		return busTransactionRepository.save(transaction);
	}

	@Override
	public List<BusTransaction> viewAllTransactions() {
		return busTransactionRepository.findAll();
	}

	@Override
	public List<BusTransaction> viewTransactionsByDate(LocalDate date) {
		// TODO Auto-generated method stub return
		return busTransactionRepository.findByDate(date);

	}

	@Override
	public BusTransaction viewTransactionById(Integer busTransactionId) {
		// TODO Auto-generated method stub return
		return busTransactionRepository.findById(busTransactionId).get();
	}

	@Override
	public BusTransaction updateAvailableSeats(Integer busTransactionId, Integer passengersCount) {
		BusTransaction busTransaction = viewTransactionById(busTransactionId);
		busTransaction.setAvailableSeats(busTransaction.getAvailableSeats() - passengersCount);
		return busTransaction;
	}

	@Override
	public User addUser(User user) { // TODO Auto-generated method stub
		return brsDao.saveUser(user);
	}

	@Override
	public Integer removeCustomer(Integer userId) {
		// TODO Auto-generated method stub return
		brsDao.removeUser(userId);
	}

	@Override
	public List<User> viewAllUsers() {
		// TODO Auto-generated method
		return brsDao.viewAllUsers();
	}

	@Override
	public List<BusTransaction> searchBuses(String source, String destination, LocalDate dateOfJourney) { // TODO
		// Auto-generated
		return brsDao.searchBuses(source, destination, dateOfJourney);
	}

	public User validateUser(String username, String password) {
		// TODO Auto-generated
		return brsDao.validateUser(username, password);
	}
	/*
	 * public Passenger addPassenger(Passenger passenger) { // TODO Auto-generated
	 * return brsDao.savePassenger(passenger); }
	 */
}
