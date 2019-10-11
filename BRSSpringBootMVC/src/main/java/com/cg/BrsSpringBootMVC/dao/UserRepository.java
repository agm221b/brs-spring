package com.cg.BrsSpringBootMVC.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.BrsSpringBootMVC.dto.User;

/**
 * @author Mayank
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * @param userId
	 * @param deleteFlag
	 * @return user with userId and deleteFlag
	 */
	public User findByUserIdAndDeleteFlag(Integer userId, Integer deleteFlag);

	/**
	 * @param username
	 * @param password
	 * @return user with given username and password
	 */
	public User findByUsernameAndPass(String username, String password);
	
	
	public Optional<User> findByUsername(String username);

	public List<User> findAllByDeleteFlag(Integer deleteFlag);
	
	
	

	
		
	}
