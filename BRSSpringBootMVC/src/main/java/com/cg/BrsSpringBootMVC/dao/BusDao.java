package com.cg.BrsSpringBootMVC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.BrsSpringBootMVC.dto.Bus;
import java.lang.Integer;
import java.util.List;

public interface BusDao extends JpaRepository<Bus, Integer> {
	
	
	public List<Bus> findByBusIdAndDeleteFlag(Integer busId, Integer deleteFlag);
	
	public List<Bus> findByDeleteFlag(Integer deleteflag);
	
	public List<Bus> findBySourceAndDestination(String source, String destination);
	
	@Query("SELECT DISTINCT(bus.source) FROM Bus bus")
	public List<String> findBySource();
	
	@Query("SELECT DISTINCT(bus.destination) FROM Bus bus")
	public List<String> findByDestination();
	
	

}
