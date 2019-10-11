package com.cg.BrsSpringBootMVC.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component("user")
@Entity
@Table(name = "user_details")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "username")
	@Size(min=3,max=20,message="Name should be between 3-20 characters")
	private String username;
	
	@Column(name="pass")
	private String pass;
	
	@Column(name = "user_type")
	@NotNull(message=" user type required")
	private Character userType;
	
	@Column(name = "email")	
	private String email;
	
	@Column(name = "phone_number")
	@NotNull(message="phone number required")
	private Integer phoneNumber;
	
	@OneToMany(cascade = CascadeType.MERGE,mappedBy = "user",fetch = FetchType.EAGER)
	private List<Booking> bookingsList;
	
	@Column(name = "delete_flag")
	private Integer deleteFlag;
	
	@Column(name="active_status")
	private boolean active;
	
	@Column(name="roles")
	private String roles;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	

	public User(Integer userId,
			@Size(min = 3, max = 20, message = "Name should be between 3-20 characters") String username, String pass,
			@NotNull(message = " user type required") Character userType, String email,
			@NotNull(message = "phone number required") Integer phoneNumber, List<Booking> bookingsList,
			Integer deleteFlag, boolean active, String roles) {
		super();
		this.userId = userId;
		this.username = username;
		this.pass = pass;
		this.userType = userType;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.bookingsList = bookingsList;
		this.deleteFlag = deleteFlag;
		this.active = active;
		this.roles = roles;
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

	public Character getUserType() {
		return userType;
	}

	public void setUserType(Character userType) {
		this.userType = userType;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	
}
