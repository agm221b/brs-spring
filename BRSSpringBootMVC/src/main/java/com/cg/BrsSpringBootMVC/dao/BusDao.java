package com.cg.BrsSpringBootMVC.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.BrsSpringBootMVC.dto.Bus;
import java.lang.Integer;
import java.util.List;

public interface BusDao extends JpaRepository<Bus, Integer> {
	
	
	public List<Bus> findByBusIdAndDeleteFlag(Integer busId, Integer deleteFlag);
	
	public List<Bus> findByDeleteFlag(Integer deleteflag);
	
	

}
