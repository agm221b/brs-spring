package com.cg.BRSSpringRest.dto;

import java.io.Serializable;

public class JwtResponse implements Serializable{
	
	private static final long serialVersionUID = 8184762193870671902L;
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}

}
