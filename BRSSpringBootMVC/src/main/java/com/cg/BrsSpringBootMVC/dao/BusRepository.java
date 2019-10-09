package com.cg.BrsSpringBootMVC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.BrsSpringBootMVC.dto.Bus;
import java.lang.Integer;
import java.util.List;

/**
 * @author Aditya
 *
 */
public interface BusRepository extends JpaRepository<Bus, Integer> {
	
	
	/**
	 * @param busId
	 * @param deleteFlag
	 * @return bus with busId and deleteFlag
	 */
	public Bus findByBusIdAndDeleteFlag(Integer busId, Integer deleteFlag);
	
	/**
	 * @param deleteflag
	 * @return List of buses with that deleteFlag
	 */
	public List<Bus> findByDeleteFlag(Integer deleteflag);
	
	/**
	 * @param source
	 * @param destination
	 * @param deleteFlag
	 * @return List of buses with that source and destination and deleteFlag
	 */
	public List<Bus> findBySourceAndDestinationAndDeleteFlag(String source, String destination, Integer deleteFlag);
	
	@Query("SELECT DISTINCT(bus.source) FROM Bus bus")
	public List<String> findBySource();
	
	@Query("SELECT DISTINCT(bus.destination) FROM Bus bus")
	public List<String> findByDestination();

}
