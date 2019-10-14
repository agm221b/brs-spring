package com.cg.BRSSpringRest;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

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

	@Autowired
	BRSService brsService;
	

	//--------------------------------------Service testing--------------------------------------//
	
	
	


	@Test
	public void testviewAllBuses() {
		assertEquals(4, brsService.viewAllBuses().size());
	}
	
	@Test
	public void testviewBusById() throws BRSException {
		Bus bus = brsService.viewBusById(37);
		assertEquals("superfast", bus.getBusName());
	}

	@Test
	public void testviewBusByRoutes()  {
		assertEquals(1, brsService.viewBusByRoutes("mumbai","goa").size());
	
	}
	
	@Test
	public void testfindSources() {
		assertEquals(1, brsService.findSources().size());
	
	}
	
	@Test
	public void testfindDestinations() {
		assertEquals(3, brsService.findDestinations().size());
	
	}

	
	 
	


	
	/*
	 * @Test public void testaddTransaction() { BusTransaction transaction = new
	 * BusTransaction(); transaction.setTransactionId(101); assertEquals(101,
	 * brsService.addTransaction(transaction).getTransactionId()); }
	 */
	
	@Test
	public void testviewAllTransactions() {
		assertEquals(56, brsService.viewAllTransactions().size());
	}
	

	@Test
	public void testviewTransactionsByDate()  {
		assertEquals(4, brsService.viewTransactionsByDate(LocalDate.of(2019, 10, 14)).size());
	
	}

	

	
	@Test
	public void testviewAllUsers() {
		assertEquals(1, brsService.viewAllUsers().size());
	}
	

	
}


	
