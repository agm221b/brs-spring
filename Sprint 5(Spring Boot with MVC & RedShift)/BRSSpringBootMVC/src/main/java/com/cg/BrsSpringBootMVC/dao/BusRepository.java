package com.cg.BrsSpringBootMVC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.BrsSpringBootMVC.dto.Bus;
import java.lang.Integer;
import java.util.List;

/**
 * @author Aditya
 * Description: This is the bus repository that maps to the bus table in the database
 * Created: 8/10/19
 * Last Modified: 9/10/19
 *
 */
public interface BusRepository extends JpaRepository<Bus, Integer> {
	
	
	/**
	 * @author Aditya
	 * Created: 8/10/19
	 * Last Modified: 9/10/19
	 * Description: This is to find the bus with particular busId and deleteFlag
	 * @param busId
	 * @param deleteFlag
	 * @return bus with busId and deleteFlag
	 */
	public Bus findByBusIdAndDeleteFlag(Integer busId, Integer deleteFlag);
	
	/**
	 * @author Aditya
	 * Created: 8/10/19
	 * Last Modified: 9/10/19
	 * Description: This is to find the List of buses with particular deleteFlag
	 * @param deleteflag
	 * @return List of buses with that deleteFlag
	 */
	public List<Bus> findByDeleteFlag(Integer deleteflag);
	
	/**
	 * @author Aditya
	 * Created: 8/10/19
	 * Last Modified: 9/10/19
	 * Description: This is to find the List of buses with particular source and destination and deleteFlag
	 * @param source
	 * @param destination
	 * @param deleteFlag
	 * @return List of buses with that source and destination and deleteFlag
	 */
	public List<Bus> findBySourceAndDestinationAndDeleteFlag(String source, String destination, Integer deleteFlag);
	
	/**
	 * @author Aditya
	 * Created: 8/10/19
	 * Last Modified: 9/10/19
	 * Description: This is to find the List of sources in the database
	 * @return List of unique sources in all the buses
	 */
	@Query("SELECT DISTINCT(bus.source) FROM Bus bus")
	public List<String> findBySource();
	
	/**
	 * @author Aditya
	 * Created: 8/10/19
	 * Last Modified: 9/10/19
	 * Description: This is to find the List of destinations in the database
	 * @return List of unique destinations in all the buses
	 */
	@Query("SELECT DISTINCT(bus.destination) FROM Bus bus")
	public List<String> findByDestination();

}
