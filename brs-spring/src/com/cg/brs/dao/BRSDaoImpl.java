package com.cg.brs.dao;

import java.time.LocalDate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.brs.dto.Booking;
import com.cg.brs.dto.Bus;
import com.cg.brs.dto.BusTransaction;
import com.cg.brs.dto.Customer;
import com.cg.brs.dto.Passenger;

@Repository("brsDao")
public class BRSDaoImpl implements BRSDao {

	@Override
	public Bus saveBus(Bus bus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer removeBus(Integer busId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bus> findAllBuses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> findBusByRoutes(String source, String destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bus findBusById(Integer busId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking saveBooking(Booking booking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer removeBooking(Integer booking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking findBookingById(Integer booking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> findAllBookings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Passenger> findAllPassengers(Integer bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusTransaction saveTransaction(BusTransaction busTransaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BusTransaction> findAllTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusTransaction findTransactionById(Integer transactionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusTransaction updateTransaction(Integer transactionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BusTransaction> findTransactionsByDate(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer removeUser(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> viewAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}
