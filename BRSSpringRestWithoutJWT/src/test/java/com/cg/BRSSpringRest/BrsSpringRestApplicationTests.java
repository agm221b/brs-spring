package com.cg.BRSSpringRest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.BRSSpringRest.dto.Bus;
import com.cg.BRSSpringRest.exception.BRSException;
import com.cg.BRSSpringRest.service.BRSService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrsSpringRestApplicationTests {

//	@Autowired
//	BRSService brsService;
//	
//	@Test
//	public void testaddBusDetails() throws BRSException {
//		Bus bus = new Bus();
//		bus.setBusName("Falcon");
//		assertEquals("Falcon", brsService.addBusDetails(bus).getBusName());
//	}
//	
//	@Test
//	public void testremoveBus() throws BRSException {
//		assertEquals(true, brsService.removeBus(55));
//	}
//
//	@Test
//	public void testviewAllBuses() {
//		assertEquals(4, brsService.viewAllBuses().size());
//	}
//	
//	@Test
//	public void testviewBusById() throws BRSException {
//		Bus bus = brsService.viewBusById(37);
//		assertEquals("superfast", bus.getBusName());
//	}
//
//	@Test
//	public void testviewBusByRoutes()  {
//		assertEquals(1, brsService.viewBusByRoutes("mumbai","goa").size());
//	
//	}
//	
//	@Test
//	public void testfindSources() {
//		assertEquals(1, brsService.findSources().size());
//	
//	}
//	
//	@Test
//	public void testfindDestinations() {
//		assertEquals(3, brsService.findDestinations().size());
//	
//	}

	
	@Test
	public void testFunction() {
		
	}
	
}
