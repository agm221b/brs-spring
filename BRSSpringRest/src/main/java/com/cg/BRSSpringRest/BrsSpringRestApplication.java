package com.cg.BRSSpringRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class BrsSpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrsSpringRestApplication.class, args);
		System.out.println("Bus Reservation System Application Started....");
	}

}
