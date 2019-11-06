package com.cg.BrsSpringBootMVC.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Aditya
 * Created: 8/10/19
 * Last Modified: 9/10/19
 * Description : Configuration for Audit Trail
 *
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class BRSConfiguration {

	/**
	 * 
	 *@author Aditya
	 * Created: 8/10/19
	 * Last Modified: 9/10/19	
	 * @return AuditorAwareImplementation 
	 */
	@Bean
	public AuditorAware<String> auditorAware(){
		return new AuditorAwareImpl();
	}

}
