package com.cg.BRSSpringRest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Tejaswini
 * Created: 13/10/19
 * Last Modified: 13/10/19
 * Description : Configuration for Audit Trail
 *
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class BRSConfiguration {

	/**
	 * 
	 *@author Tejaswini
	 * Created: 13/10/19
	 * Last Modified: 13/10/19	
	 * @return AuditorAwareImplementation 
	 */
	@Bean
	public AuditorAware<String> auditorAware(){
		return new AuditorAwareImpl();
	}

}
