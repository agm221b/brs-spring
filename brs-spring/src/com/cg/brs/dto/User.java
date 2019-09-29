package com.cg.brs.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "username")
	private String username;
	@Column(name="pass")
	private String pass;
	@Column(name = "user_type")
	private Character customerType;
	@Column(name = "email")
	private String email;
	@Column(name = "phone_number")
	private Integer phoneNumber;
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "booking_fk")
	private List<Booking> bookingsList;
	@Column(name = "delete_flag")
	private Integer deleteFlag;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String username, String pass, Character customerType, String email, Integer phoneNumber,
			List<Booking> bookingsList, Integer deleteFlag) {
		this.userId = userId;
		this.username = username;
		this.pass = pass;
		this.customerType = customerType;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.bookingsList = bookingsList;
		this.deleteFlag = deleteFlag;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Character getCustomerType() {
		return customerType;
	}

	public void setCustomerType(Character customerType) {
		this.customerType = customerType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Booking> getBookingsList() {
		return bookingsList;
	}

	public void setBookingsList(List<Booking> bookingsList) {
		this.bookingsList = bookingsList;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", pass=" + pass + ", customerType=" + customerType
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", bookingsList=" + bookingsList
				+ ", deleteFlag=" + deleteFlag + "]";
	}
	
	
	
}
