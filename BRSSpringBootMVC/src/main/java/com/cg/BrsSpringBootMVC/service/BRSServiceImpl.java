package com.cg.BrsSpringBootMVC.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.BrsSpringBootMVC.dao.BookingRepository;
import com.cg.BrsSpringBootMVC.dao.BusDao;
import com.cg.BrsSpringBootMVC.dao.BusTransactionRepository;
import com.cg.BrsSpringBootMVC.dto.Booking;
import com.cg.BrsSpringBootMVC.dto.Bus;
import com.cg.BrsSpringBootMVC.dto.BusTransaction;
import com.cg.BrsSpringBootMVC.dto.Passenger;
import com.cg.BrsSpringBootMVC.dto.User;

@Service("brsService")
@Transactional
public class BRSServiceImpl implements BRSService {

	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	BusTransactionRepository busTransactionRepository;
	@Autowired
	BusDao busDao;

	
	  @Override public Bus addBusDetails(Bus bus) { // TODO Auto-generated method
	  stub return brsDao.saveBus(bus); }
	 
	
	  @Override public Integer removeBus(Integer busId) { // TODO Auto-generated
	  method stub return brsDao.removeBus(busId); }
	  
	  @Override public List<Bus> viewAllBuses() { // TODO Auto-generated method
	  stub return brsDao.findAllBuses(); }
	  
	  @Override 
	  public Bus viewBusById(Integer busId) { 
		  // TODO Auto-generated
		  return busDao.findById(busId).get();
	  }
	  
	  @Override 
	  public List<Bus> viewBusByRoutes(String source, String destination) {
		  return busDao.findBySourceAndDestination(source, destination);
	  }
	  
	  
	  @Override public List<String> findSrc() { 
		  // TODO Auto-generated method stub
	  return busDao.findBySource(); 
	  }
	  
	  @Override public List<String> findDest() { 
		  // TODO Auto-generated method stub
	  return busDao.findByDestination(); 
	  }
	 

	@Override
	public Booking createBooking(Booking booking) {
		// TODO Auto-generated method stub
		return bookingRepository.save(booking);
	}

	@Override
	public Booking cancelBooking (Integer bookingId) {
		// TODO Auto-generated method stub
		Booking booking=bookingRepository.findById(bookingId).get();
		booking.setBookingStatus("CANCELLED");
		return booking;
	}

	@Override
	public List<Booking> viewAllBookings(User user) {
		// TODO Auto-generated method stub
		return bookingRepository.findByUser(user);
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
  public List<BusTransaction> viewTransactionsByDate(LocalDate date){
	  // TODO Auto-generated method stub return
	  return busTransactionRepository.findByDate(date);
  
  }
  
  @Override 
  public BusTransaction viewTransactionById(Integer busTransactionId){
	  // TODO Auto-generated method stub return
	  return busTransactionRepository.findById(busTransactionId).get();
  }
  
  @Override public BusTransaction updateAvailableSeats(Integer
  busTransactionId,Integer passengersCount) {
	  BusTransaction busTransaction=viewTransactionById(busTransactionId);
	  busTransaction.setAvailableSeats(busTransaction.getAvailableSeats()-passengersCount);
	  return busTransaction; 
	  }
  
  @Override public User addUser(User user) { // TODO Auto-generated method stub
  return brsDao.saveUser(user); }
  
  @Override public Integer removeCustomer(Integer userId) { // TODO
  Auto-generated method stub return brsDao.removeUser(userId); }
  
  @Override public List<User> viewAllUsers() { // TODO Auto-generated method
  stub return brsDao.viewAllUsers(); }
  
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
  
  
  public Passenger addPassenger(Passenger passenger) { // TODO Auto-generated
  method stub return brsDao.savePassenger(passenger); } public User
  validateUser(String username, String password) { // TODO Auto-generated
  method stub return brsDao.validateUser(username, password); }
  
  
  }
 
