package com.cg.BRSSpringRest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.BRSSpringRest.dao.UserRepository;
import com.cg.BRSSpringRest.dto.BRSUserDetails;

@Service
public class BRSUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
Optional<com.cg.BRSSpringRest.dto.User> user=userRepository.findByUsername(username);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not Found: "+username));
		
		return user.map(BRSUserDetails::new).get();
	}

}
