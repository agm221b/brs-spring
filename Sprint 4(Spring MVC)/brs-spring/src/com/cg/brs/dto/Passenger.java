package com.cg.brs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component("passenger")
@Entity
@Table(name = "passenger")
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "passenger_id")
	private Integer passengerId;
	@Column(name = "passenger_name")
	@NotBlank(message="name required")
	@Size(min=3,max=20,message="Name should be between 3-20 characters")
	private String passengerName;
	@Column(name = "passenger_age")
	@NotNull(message="age required")
	private Integer passengerAge;
	@Column(name = "passenger_gender")
	@NotNull(message="gender required")
	private Character passengerGender;

	public Passenger() {

	}

	public Passenger(Integer passengerId, String passengerName, Integer passengerAge, Character passengerGender) {
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerGender = passengerGender;
	}

	public Integer getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Integer getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}

	public Character getPassengerGender() {
		return passengerGender;
	}

	public void setPassengerGender(Character passengerGender) {
		this.passengerGender = passengerGender;
	}

	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", passengerName=" + passengerName + ", passengerAge="
				+ passengerAge + ", passengerGender=" + passengerGender + "]";
	}

	

}
