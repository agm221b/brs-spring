package com.cg.BrsSpringBootMVC.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.BrsSpringBootMVC.dto.Booking;
import com.cg.BrsSpringBootMVC.dto.Bus;
import com.cg.BrsSpringBootMVC.dto.BusTransaction;
import com.cg.BrsSpringBootMVC.dto.Passenger;
import com.cg.BrsSpringBootMVC.dto.User;

@Repository("brsDao")
public class BRSDaoImpl implements BRSDao {
	
	@PersistenceContext
	EntityManager entityManager;

	/**
	 *method to add bus object by orm methodology
	 */
	@Override
	public Bus saveBus(Bus bus) {
		// TODO Auto-generated method stub
		entityManager.persist(bus);
		return bus;
	}

	/**
	 *method to remove bus, returns 1 if removed else 0
	 */
	@Override
	public Integer removeBus(Integer busId) {
		// TODO Auto-generated method stub
		Bus busUpdate = entityManager.find(Bus.class, busId);
		if(busUpdate==null) {
			return 0;
		}
		busUpdate.setDeleteFlag(1);
		entityManager.merge(busUpdate);
		return 1;
	}

	/**
	 *method to findAllBuses using typedquery
	 */
	@Override
	public List<Bus> findAllBuses() {
		// TODO Auto-generated method stub
		TypedQuery<Bus> query = entityManager.createQuery("SELECT bus FROM Bus bus where bus.deleteFlag = 0",
				Bus.class);
		return query.getResultList();
	}

	/**
	 *method to return list of buses based on given route
	 */
	@Override
	public List<Object[]> findBusByRoutes(String source, String destination) {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("SELECT bus.busId,bus.busName,bus.busType,bus.busClass,bus.costPerSeat FROM Bus bus WHERE bus.source=:source AND bus.destination=:destination");
		query.setParameter("source", source);
		query.setParameter("destination", destination);
		List<Object[]> results=query.getResultList();
		return results;
	}

	/**
	 *method to find bus based on given busId 
	 */
	@Override
	public Bus findBusById(Integer busId) {
		// TODO Auto-generated method stub
		return entityManager.find(Bus.class, busId);
	}
	
	

	/**
	 *method to return the list of unique bus sources
	 */
	@Override
	public List<String> findSrc() {
		// TODO Auto-generated method stub
		TypedQuery<String> query = entityManager.createQuery("SELECT distinct(bus.source) FROM Bus bus", String.class); 
		return query.getResultList();
	}

	/**
	 *method to return the list of unique bus destinations
	 */
	@Override
	public List<String> findDest() {
		// TODO Auto-generated method stub
		TypedQuery<String> query = entityManager.createQuery("SELECT distinct(bus.destination) FROM Bus bus", String.class);
		return query.getResultList();
	}

	/**
	 *method to add booking object
	 */
	@Override
	public Booking saveBooking(Booking booking) {
		booking=entityManager.merge(booking);
		booking.setBus(booking.getBus());
		booking.setPassengers(booking.getPassengers());
		entityManager.persist(booking);
		return booking;								//to be set
	}

	/**
	 *method to remove booking based on given bookingId
	 */
	@Override
	public Integer removeBooking(Integer bookingId) {
		// TODO Auto-generated method stub
		Booking removeBooking = entityManager.find(Booking.class, bookingId);
		removeBooking.setBookingStatus("CANCELLED");
		entityManager.merge(removeBooking);
		return 1;
	}

	/**
	 *method to find booking based on given bookingId
	 */
	@Override
	public Booking findBookingById(Integer bookingId) {
		// TODO Auto-generated method stub
		return entityManager.find(Booking.class, bookingId);
	}

	/**
	 *method to return list of all bookings
	 */
	@Override
	public List<Booking> findAllBookings() {
		// TODO Auto-generated method stub
		TypedQuery<Booking> query = entityManager.createQuery("SELECT booking FROM Booking booking ", Booking.class);
		return query.getResultList();
	}

	/**
	 *method to return list of all passengers based on given bookingId
	 */
	@Override
	public List<Passenger> findAllPassengers(Integer bookingId) {
		// TODO Auto-generated method stub
		TypedQuery<Passenger> query = entityManager.createQuery("SELECT passenger FROM Passenger passenger", Passenger.class);
		return query.getResultList();
	}

	/**
	 *method to add busTransacton object
	 */
	@Override
	public BusTransaction saveTransaction(BusTransaction busTransaction) {
		// TODO Auto-generated method stub
		busTransaction=entityManager.merge(busTransaction);
		busTransaction.setBus(busTransaction.getBus());
		entityManager.persist(busTransaction);
		return busTransaction;
	}

	/**
	 *method to list all BusTransactions using typedquery
	 */
	@Override
	public List<BusTransaction> findAllTransactions() {
		// TODO Auto-generated method stub
		TypedQuery<BusTransaction> query=entityManager.createQuery("FROM BusTransaction", BusTransaction.class);
		return query.getResultList();
	}

	/**
	 *method to return BusTransaction using transactionId
	 */
	@Override
	public BusTransaction findTransactionById(Integer transactionId) {
		// TODO Auto-generated method stub
		return entityManager.find(BusTransaction.class, transactionId);
	}

	/**
	 *method to return updated available seats
	 */
	@Override
	public BusTransaction updateAvailableSeats(Integer transactionId,Integer passengersCount) {
		// TODO Auto-generated method stub
		BusTransaction busTransaction=findTransactionById(transactionId);
		busTransaction.setAvailableSeats(busTransaction.getAvailableSeats()-passengersCount);		//Integer passengerCount
		busTransaction=entityManager.merge(busTransaction);
		return busTransaction;
	}

	/**
	 *method to list BusTransaction based on date
	 */
	@Override
	public List<BusTransaction> findTransactionsByDate(LocalDate date) {
		// TODO Auto-generated method stub
		TypedQuery<BusTransaction> query=entityManager.createQuery("FROM BusTransaction WHERE date=:date", BusTransaction.class);
		query.setParameter("date", date);
		return query.getResultList();
	}

	/**
	 *method to add user object
	 */
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		user.setBookingsList(user.getBookingsList());
		user.setDeleteFlag(0);
		User userSave = entityManager.merge(user);
		user.setUserId(user.getUserId());
		entityManager.persist(userSave);
		return user;
	}

	/**
	 *method to remove user based on given userId
	 */
	@Override
	public Integer removeUser(Integer userId) {
		// TODO Auto-generated method stub
		User userUpdate = entityManager.find(User.class, userId);
		userUpdate.setDeleteFlag(1);
		entityManager.merge(userUpdate);
		return 1;
	}

	/**
	 *method to list AllUsers
	 */
	@Override
	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		TypedQuery<User> query = entityManager.createQuery("SELECT user FROM User user where user.deleteFlag = 0",
				User.class);
		return query.getResultList();
	}
	
	

	/**
	 *method to validate user
	 */
	@Override
	public User validateUser(String username, String password) {
		// TODO Auto-generated method stub
		List<User> users =viewAllUsers();
		for (User user : users) {
			if(username.equals(user.getUsername()) && password.equals(user.getPass())){
				
				return user;
			}
		}
		return null;
	}

	/**
	 *method to return transaction based on given route
	 */
	@Override
	public List<BusTransaction> searchBuses(String source, String destination, LocalDate dateOfJourney) {
		// TODO Auto-generated method stub
		List<BusTransaction> transactionsByRoutes=new ArrayList<BusTransaction>();
		for(BusTransaction busTransaction:findTransactionsByDate(dateOfJourney)) {
			if(busTransaction.getDate().equals(dateOfJourney)) {
				if(busTransaction.getBus().getSource().equalsIgnoreCase(source) && busTransaction.getBus().getDestination().equalsIgnoreCase(destination)) {
					transactionsByRoutes.add(busTransaction);
				}
			}
		}
		return transactionsByRoutes;
	}

	/**
	 *method to add passenger 
	 */
	@Override
	public Passenger savePassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		entityManager.persist(passenger);
		return passenger;
	}

}
