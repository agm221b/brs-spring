package com.cg.BrsSpringBootMVC.dao;

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

	public User findByUsernameAndPass(String username, String password);
	
	
	

	
		
	}
