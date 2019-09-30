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
		return null;
	}

	@Override
	public List<Bus> viewAllBuses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bus viewBusById(Integer busId) {
		// TODO Auto-generated method stub
		return brsDao.findBusById(busId);
	}

	@Override
	public List<Object[]> viewBusByRoutes(String source, String destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking createBooking(Booking booking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer removeBooking(Integer bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> viewAllBookings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusTransaction addTransaction(BusTransaction transaction) {
		// TODO Auto-generated method stub
		return brsDao.saveTransaction(transaction);
	}

	@Override
	public List<BusTransaction> viewAllTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BusTransaction> viewTransactionsByDate(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusTransaction viewTransactionById(Integer busTransactionId) {
		// TODO Auto-generated method stub
		return brsDao.findTransactionById(busTransactionId);
	}

	@Override
	public BusTransaction updateTransaction(Integer busTransactionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer removeCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> viewAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BusTransaction> searchBuses(String source, String destination, LocalDate dateOfJourney) {
		// TODO Auto-generated method stub
		return brsDao.searchBuses(source, destination, dateOfJourney);
	}

	
}
