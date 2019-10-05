package com.cg.BrsSpringBootMVC.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.BrsSpringBootMVC.dto.Booking;

public interface BookingDao extends JpaRepository<Booking, Integer> {

}
