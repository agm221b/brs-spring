package com.cg.BRSSpringRest.configuration;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

/**
 *@author Aditya
 * Created: 8/10/19
 * Last Modified: 9/10/19
 * Description : Audit Trail Implementation
 */
public class AuditorAwareImpl implements AuditorAware<String> {


	/**
	 * @author Aditya
	 * Created: 8/10/19
	 * Last Modified: 9/10/19
	 * @return Auditor Name
	 */
	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		
		//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 
		/*
		 * if (authentication == null || !authentication.isAuthenticated()) { return
		 * null; }
		 */
 
        return Optional.of("tejaswini");
		
	}

}
