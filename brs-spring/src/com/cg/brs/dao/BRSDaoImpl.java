package com.cg.brs.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.brs.dto.Booking;
import com.cg.brs.dto.Bus;
import com.cg.brs.dto.BusTransaction;
import com.cg.brs.dto.Passenger;
import com.cg.brs.dto.User;

@Repository("brsDao")
public class BRSDaoImpl implements BRSDao {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Bus saveBus(Bus bus) {
		// TODO Auto-generated method stub
		entityManager.persist(bus);
		return bus;
	}

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

	@Override
	public List<Bus> findAllBuses() {
		// TODO Auto-generated method stub
		TypedQuery<Bus> query = entityManager.createQuery("SELECT bus FROM Bus bus where bus.deleteFlag = 0",
				Bus.class);
		return query.getResultList();
	}

	@Override
	public List<Object[]> findBusByRoutes(String source, String destination) {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("SELECT bus.busId,bus.busName,bus.busType,bus.busClass,bus.costPerSeat FROM Bus bus WHERE bus.source=:source AND bus.destination=:destination");
		query.setParameter("source", source);
		query.setParameter("destination", destination);
		List<Object[]> results=query.getResultList();
		return results;
	}

	@Override
	public Bus findBusById(Integer busId) {
		// TODO Auto-generated method stub
		return entityManager.find(Bus.class, busId);
	}

	@Override
	public Booking saveBooking(Booking booking) {
		booking=entityManager.merge(booking);
		booking.setBus(booking.getBus());
		booking.setPassengers(booking.getPassengers());
		booking.setBookingStatus("BOOKED");
		entityManager.persist(booking);
		return booking;								//to be set
	}

	@Override
	public Integer removeBooking(Integer bookingId) {
		// TODO Auto-generated method stub
		Booking removeBooking = entityManager.find(Booking.class, bookingId);
		removeBooking.setBookingStatus("CANCELLED");
		entityManager.merge(removeBooking);
		return 1;
	}

	@Override
	public Booking findBookingById(Integer bookingId) {
		// TODO Auto-generated method stub
		return entityManager.find(Booking.class, bookingId);
	}

	@Override
	public List<Booking> findAllBookings() {
		// TODO Auto-generated method stub
		TypedQuery<Booking> query = entityManager.createQuery("SELECT booking FROM Booking booking ", Booking.class);
		return query.getResultList();
	}

	@Override
	public List<Passenger> findAllPassengers(Integer bookingId) {
		// TODO Auto-generated method stub
		TypedQuery<Passenger> query = entityManager.createQuery("SELECT passenger FROM Passenger passenger", Passenger.class);
		return query.getResultList();
	}

	@Override
	public BusTransaction saveTransaction(BusTransaction busTransaction) {
		// TODO Auto-generated method stub
		busTransaction=entityManager.merge(busTransaction);
		busTransaction.setBus(busTransaction.getBus());
		entityManager.persist(busTransaction);
		return busTransaction;
	}

	@Override
	public List<BusTransaction> findAllTransactions() {
		// TODO Auto-generated method stub
		TypedQuery<BusTransaction> query=entityManager.createQuery("FROM BusTransaction", BusTransaction.class);
		return query.getResultList();
	}

	@Override
	public BusTransaction findTransactionById(Integer transactionId) {
		// TODO Auto-generated method stub
		return entityManager.find(BusTransaction.class, transactionId);
	}

	@Override
	public BusTransaction updateTransaction(Integer transactionId) {
		// TODO Auto-generated method stub
		BusTransaction busTransaction=findTransactionById(transactionId);
		//busTransaction.setAvailableSeats(busTransaction.getAvailableSeats()-passengersCount);		//Integer passengerCount
		busTransaction=entityManager.merge(busTransaction);
		
		return busTransaction;
	}

	@Override
	public List<BusTransaction> findTransactionsByDate(LocalDate date) {
		// TODO Auto-generated method stub
		TypedQuery<BusTransaction> query=entityManager.createQuery("FROM BusTransaction WHERE date=:date", BusTransaction.class);
		query.setParameter("date", date);
		return query.getResultList();
	}

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

	@Override
	public Integer removeUser(Integer userId) {
		// TODO Auto-generated method stub
		User userUpdate = entityManager.find(User.class, userId);
		userUpdate.setDeleteFlag(1);
		entityManager.merge(userUpdate);
		return 1;
	}

	@Override
	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		TypedQuery<User> query = entityManager.createQuery("SELECT user FROM User user where user.deleteFlag = 0",
				User.class);
		return query.getResultList();
	}
	
	

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

	@Override
	public Passenger savePassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		entityManager.persist(passenger);
		return passenger;
	}

}
