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

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer customerId;
	@Column(name = "username")
	private String username;
	@Column(name="pass")
	private String pass;
	@Column(name = "customer_type")
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

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer userId, String username, String pass, Character userType, String email, Integer phoneNumber,
			List<Booking> bookingsList, Integer deleteFlag) {
		super();
		this.customerId = userId;
		this.username = username;
		this.pass = pass;
		this.customerType = userType;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.bookingsList = bookingsList;
		this.deleteFlag = deleteFlag;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", username=" + username + ", pass=" + pass + ", customerType="
				+ customerType + ", email=" + email + ", phoneNumber=" + phoneNumber + ", bookingsList=" + bookingsList
				+ ", deleteFlag=" + deleteFlag + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingsList == null) ? 0 : bookingsList.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((customerType == null) ? 0 : customerType.hashCode());
		result = prime * result + ((deleteFlag == null) ? 0 : deleteFlag.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (bookingsList == null) {
			if (other.bookingsList != null)
				return false;
		} else if (!bookingsList.equals(other.bookingsList))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerType == null) {
			if (other.customerType != null)
				return false;
		} else if (!customerType.equals(other.customerType))
			return false;
		if (deleteFlag == null) {
			if (other.deleteFlag != null)
				return false;
		} else if (!deleteFlag.equals(other.deleteFlag))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

}
