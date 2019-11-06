package com.cg.BRSSpringRest.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.BRSSpringRest.dto.BusTransaction;

public interface BusTransactionRepository extends JpaRepository<BusTransaction, Integer> {
	
	public List<BusTransaction> findByDate(LocalDate date);

}
