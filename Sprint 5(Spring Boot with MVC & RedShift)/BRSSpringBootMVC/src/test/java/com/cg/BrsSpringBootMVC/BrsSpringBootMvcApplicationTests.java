package com.cg.BrsSpringBootMVC;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.BrsSpringBootMVC.dto.Bus;
import com.cg.BrsSpringBootMVC.dto.BusTransaction;
import com.cg.BrsSpringBootMVC.dto.User;
import com.cg.BrsSpringBootMVC.exception.BRSException;
import com.cg.BrsSpringBootMVC.service.BRSService;

/**
 * @author Mayank Created: 12/10/19 Last modified: 12/10/19 Description: junit
 *         testing
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BrsSpringBootMvcApplicationTests {

	
	/*
	 * @Autowired TestRestTemplate restTemplate;
	 * 
	 * @Autowired BRSService brsService;
	 * //---------------------------------Controller
	 * testing----------------------------------------//
	 */
	  @Test public void checkshowHomePage() { 
		  
	  }
	  
	 
}
