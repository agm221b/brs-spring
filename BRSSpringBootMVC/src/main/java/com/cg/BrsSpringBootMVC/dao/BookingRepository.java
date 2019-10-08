package com.cg.BrsSpringBootMVC.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.BrsSpringBootMVC.dto.Booking;
import com.cg.BrsSpringBootMVC.dto.User;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
	/**
	 * returns the list of bookings for a particular user
	 * @param user
	 * @return List<Booking>
	 */
	public List<Booking> findByUser(User user);
	
}
