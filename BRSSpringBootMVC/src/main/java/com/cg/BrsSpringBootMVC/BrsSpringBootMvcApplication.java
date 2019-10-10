package com.cg.BrsSpringBootMVC;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Tejaswini
 *
 */
@SpringBootApplication
public class BrsSpringBootMvcApplication {
	
	private static Logger logger = LoggerFactory.getLogger(BrsSpringBootMvcApplication.class);


	public static void main(String[] args) {
		
		SpringApplication.run(BrsSpringBootMvcApplication.class, args);
		System.out.println("Hello Springboot");
		logger.debug("Hello SpringBoot");
		
	}

}
