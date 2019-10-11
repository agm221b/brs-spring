package com.cg.BrsSpringBootMVC.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.cg.BrsSpringBootMVC.dto.BRSUrlAuthenticationSuccessHandler;
import com.cg.BrsSpringBootMVC.service.BRSUserDetailsService;

@EnableWebSecurity
public class BRSWebSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	BRSUserDetailsService userDetailsService;
	
	@Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
    }
	
	 	@Bean
	    public AuthenticationSuccessHandler brsAuthenticationSuccessHandler(){
	        return new BRSUrlAuthenticationSuccessHandler();
	    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		.antMatchers("/adminhome").hasRole("ADMIN")
		.antMatchers("/customerhome").hasAnyRole("ADMIN","CUSTOMER")
		.and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password")
		.successHandler(brsAuthenticationSuccessHandler())
		.and().logout().logoutSuccessUrl("/");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
