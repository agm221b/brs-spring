package com.cg.BRSSpringRest.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.cg.BRSSpringRest.dto.UserDetailsImpl;

/**
 *@author Tejaswini
 * Created: 13/10/19
 * Last Modified: 13/10/19
 * Description : Audit Trail Implementation
 */
public class AuditorAwareImpl implements AuditorAware<String> {


	/**
	 * @author Tejaswini
	 * Created: 13/10/19
	 * Last Modified: 13/10/19
	 * @return Auditor Name
	 */
	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
 
        return Optional.of(((UserDetailsImpl)authentication.getPrincipal()).getUsername());
		
	}

}
