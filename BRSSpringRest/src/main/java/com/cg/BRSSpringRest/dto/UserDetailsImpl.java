package com.cg.BRSSpringRest.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return active;
	}

	private String username;
	private String password;
	private Character userType;
	private String email;
	private Integer phoneNumber;
	private List<Booking> bookingsList;
	private Integer deleteFlag;
	private boolean active;
	private List<GrantedAuthority> authorities;
	private String roles;
	
	
	

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public UserDetailsImpl(String username, String password, Character userType, String email, Integer phoneNumber,
			List<Booking> bookingsList, Integer deleteFlag, boolean active, List<GrantedAuthority> authorities, String roles) {
		
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.bookingsList = bookingsList;
		this.deleteFlag = deleteFlag;
		this.active = active;
		//this.authorities = authorities;
		this.roles = roles;
		this.authorities=Arrays.stream(roles.split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}
	
	public UserDetailsImpl(User user) {
		this.username = user.getUsername();
		this.password=user.getPass();
		this.active=user.isActive();
		this.userType = user.getUserType();
		this.email = user.getEmail();
		this.phoneNumber = user.getPhoneNumber();
		this.bookingsList = user.getBookingsList();
		this.deleteFlag = user.getDeleteFlag();
		//this.authorities = authorities;
		
		this.roles = user.getRoles();
		this.authorities=Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDetailsImpl [username=" + username + ", password=" + password + ", userType=" + userType
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", bookingsList=" + bookingsList
				+ ", deleteFlag=" + deleteFlag + ", active=" + active + ", authorities=" + authorities + ", roles="
				+ roles + "]";
	}


	
}