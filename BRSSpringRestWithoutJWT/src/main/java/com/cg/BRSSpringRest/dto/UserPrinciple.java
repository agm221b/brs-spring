package com.cg.BRSSpringRest.dto;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserPrinciple implements UserDetails{

	private static final long serialVersionUID = 2494730592020036957L;
	
	private Integer userId;
	private String username;
	@JsonIgnore
	private String password;
	private String email;
	private Character userType;
	private String phoneNumber;
	private List<Booking> bookingsList;
	private Integer deleteFlag;
	private Boolean active;
	private String roles;
	private Collection<? extends GrantedAuthority> authorities;
	
	
	
	public UserPrinciple(Integer userId, String username, String password, String email, Character userType,
			String phoneNumber, List<Booking> bookingsList, Integer deleteFlag, Boolean active, String roles,
			Collection<? extends GrantedAuthority> authorities) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.userType = userType;
		this.phoneNumber = phoneNumber;
		this.bookingsList = bookingsList;
		this.deleteFlag = deleteFlag;
		this.active = active;
		this.roles = roles;
		this.authorities = authorities;
	}

	public static UserPrinciple build(User user) {
		List<GrantedAuthority> authorities=Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		
		return new UserPrinciple(user.getUserId(), user.getUsername(), user.getPass(), user.getEmail(), user.getUserType(), user.getPhoneNumber(),user.getBookingsList(), user.getDeleteFlag(), user.isActive(), user.getRoles(), authorities);
	}
	
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Character getUserType() {
		return userType;
	}

	public void setUserType(Character userType) {
		this.userType = userType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

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
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(userId, user.userId);
    }

}
