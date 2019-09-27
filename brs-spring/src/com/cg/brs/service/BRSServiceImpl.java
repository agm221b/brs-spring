package com.cg.brs.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.brs.dto.Booking;
import com.cg.brs.dto.Bus;
import com.cg.brs.dto.BusTransaction;
import com.cg.brs.dto.Customer;

@Service("brsService")
public class BRSServiceImpl implements BRSService {

	@Override
	public Bus addBusDetails(Bus bus) {
		// TODO Auto-generated method stub
		return null;
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
		return null;
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
		return null;
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
		return null;
	}

	@Override
	public BusTransaction updateTransaction(Integer busTransactionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer addUser(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer removeCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> viewAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
