package com.cg.brs.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.brs.dao.BRSDao;
import com.cg.brs.dto.Booking;
import com.cg.brs.dto.Bus;
import com.cg.brs.dto.BusTransaction;
import com.cg.brs.dto.Passenger;
import com.cg.brs.dto.User;

@Service("brsService")
@Transactional
public class BRSServiceImpl implements BRSService {

	@Autowired
	BRSDao brsDao;
	@Override
	public Bus addBusDetails(Bus bus) {
		// TODO Auto-generated method stub
		return brsDao.saveBus(bus);
	}

	@Override
	public Integer removeBus(Integer busId) {
		// TODO Auto-generated method stub
		return brsDao.removeBus(busId);
	}

	@Override
	public List<Bus> viewAllBuses() {
		// TODO Auto-generated method stub
		return brsDao.findAllBuses();
	}

	@Override
	public Bus viewBusById(Integer busId) {
		// TODO Auto-generated method stub
		return brsDao.findBusById(busId);
	}

	@Override
	public List<Object[]> viewBusByRoutes(String source, String destination) {
		// TODO Auto-generated method stub
		return brsDao.findBusByRoutes(source, destination);
		
	}
	

	@Override
	public List<String> findSrc() {
		// TODO Auto-generated method stub
		return brsDao.findSrc();
	}

	@Override
	public List<String> findDest() {
		// TODO Auto-generated method stub
		return brsDao.findDest();
	}

	@Override
	public Booking createBooking(Booking booking) {
		// TODO Auto-generated method stub
		return brsDao.saveBooking(booking);
	}

	@Override
	public Integer removeBooking(Integer bookingId) {
		// TODO Auto-generated method stub
		return brsDao.removeBooking(bookingId);
	}

	@Override
	public List<Booking> viewAllBookings() {
		// TODO Auto-generated method stub
		return brsDao.findAllBookings();
	}
	
	

	@Override
	public Booking findBookingById(Integer bookingId) {
		// TODO Auto-generated method stub
		return brsDao.findBookingById(bookingId);
	}

	@Override
	public BusTransaction addTransaction(BusTransaction transaction) {
		// TODO Auto-generated method stub
		return brsDao.saveTransaction(transaction);
	}

	@Override
	public List<BusTransaction> viewAllTransactions() {
		// TODO Auto-generated method stub
		return brsDao.findAllTransactions();
	}

	@Override
	public List<BusTransaction> viewTransactionsByDate(LocalDate date) {
		// TODO Auto-generated method stub
		return brsDao.findTransactionsByDate(date);
	}

	@Override
	public BusTransaction viewTransactionById(Integer busTransactionId) {
		// TODO Auto-generated method stub
		return brsDao.findTransactionById(busTransactionId);
	}

	@Override
	public BusTransaction updateAvailableSeats(Integer busTransactionId,Integer passengersCount) {
		// TODO Auto-generated method stub
		return brsDao.updateAvailableSeats(busTransactionId, passengersCount);
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return brsDao.saveUser(user);
	}

	@Override
	public Integer removeCustomer(Integer userId) {
		// TODO Auto-generated method stub
		return brsDao.removeUser(userId);
	}

	@Override
	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		return brsDao.viewAllUsers();
	}

	@Override
	public List<BusTransaction> searchBuses(String source, String destination, LocalDate dateOfJourney) {
		// TODO Auto-generated method stub
		return brsDao.searchBuses(source, destination, dateOfJourney);
	}

	
	public Passenger addPassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		return brsDao.savePassenger(passenger);
	}
	public User validateUser(String username, String password) {
		// TODO Auto-generated method stub
		return brsDao.validateUser(username, password);
	}

	
}
