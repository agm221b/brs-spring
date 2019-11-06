package com.cg.BrsSpringBootMVC.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.BrsSpringBootMVC.dto.Booking;
import com.cg.BrsSpringBootMVC.dto.User;

/**
 * @author Tejaswini
 * Description: DAO Layer for Booking
 * Created On : 05/10/2019
 *
 */
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
	/**
	 * @author Tejaswini
	 * Description: returns the list of bookings for a particular user
	 * @param user
	 * @return List<Booking>
	 * Created on : 05/10/2019
	 */
	public List<Booking> findByUser(User user);
	
	
}
