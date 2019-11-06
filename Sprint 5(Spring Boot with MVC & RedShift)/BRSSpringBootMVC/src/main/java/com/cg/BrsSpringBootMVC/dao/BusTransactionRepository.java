package com.cg.BrsSpringBootMVC.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.BrsSpringBootMVC.dto.BusTransaction;

/**
 * @author Tejaswini
 *
 */
public interface BusTransactionRepository extends JpaRepository<BusTransaction, Integer> {
	
	public List<BusTransaction> findByDate(LocalDate date);

}
