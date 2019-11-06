package com.cg.BRSSpringRest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.BRSSpringRest.dto.Booking;
import com.cg.BRSSpringRest.dto.User;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	/**
	 * returns the list of bookings for a particular user
	 * @param user
	 * @return List<Booking>
	 */
	public List<Booking> findByUser(User user);
}
