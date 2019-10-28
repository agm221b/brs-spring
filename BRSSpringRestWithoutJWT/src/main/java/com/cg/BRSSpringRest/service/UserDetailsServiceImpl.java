package com.cg.BRSSpringRest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.BRSSpringRest.dao.UserRepository;
import com.cg.BRSSpringRest.dto.User;
import com.cg.BRSSpringRest.dto.UserPrinciple;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username).orElseThrow(
		        () -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
		 
		    return UserPrinciple.build(user);
	}

}
