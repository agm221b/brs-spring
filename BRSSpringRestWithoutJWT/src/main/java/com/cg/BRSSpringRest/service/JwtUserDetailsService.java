package com.cg.BRSSpringRest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.BRSSpringRest.dao.UserRepository;
import com.cg.BRSSpringRest.dto.User;
import com.cg.BRSSpringRest.dto.UserDetailsImpl;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;


	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
Optional<User> user=userRepository.findByUsername(username);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not Found: "+username));
		
		return user.map(UserDetailsImpl::new).get();
	}
	

}
