package com.cg.BrsSpringBootMVC.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.BrsSpringBootMVC.dao.UserRepository;
import com.cg.BrsSpringBootMVC.dto.BRSUserDetails;
import com.cg.BrsSpringBootMVC.dto.User;

@Service("brsuserdetailsservice")
public class BRSUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user=userRepository.findByUsername(username);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not Found: "+username));
		
		return user.map(BRSUserDetails::new).get();
	}

}
