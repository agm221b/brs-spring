package com.cg.BRSSpringRest.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.BRSSpringRest.dto.User;

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


	/**
	 * @param username
	 * @return user with given username
	 */
	public Optional<User> findByUsername(String username);
	
	/**
	 * @param userId
	 * @return user with given userId
	 */
	public User findByUserId(Integer userId);
	
	
	

	
		
	}
