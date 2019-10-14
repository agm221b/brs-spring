package com.cg.BRSSpringRest.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.BRSSpringRest.dao.UserRepository;
import com.cg.BRSSpringRest.dto.User;
import com.cg.BRSSpringRest.dto.UserDetailsImpl;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return user.map(UserDetailsImpl::new).get();
	}
	
	public User save(UserDetailsImpl user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPass(bcryptEncoder.encode(user.getPassword()));
		newUser.setPhoneNumber(user.getPhoneNumber());
		newUser.setUserType(user.getUserType());
		newUser.setDeleteFlag(user.getDeleteFlag());
		newUser.setEmail(user.getEmail());
		newUser.setRoles(user.getRoles());
        newUser.setActive(user.isActive());
		return userRepository.save(newUser);
	}
}