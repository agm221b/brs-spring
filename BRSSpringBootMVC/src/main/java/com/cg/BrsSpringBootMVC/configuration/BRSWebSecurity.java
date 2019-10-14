package com.cg.BrsSpringBootMVC.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.cg.BrsSpringBootMVC.dto.BRSUrlAuthenticationSuccessHandler;
import com.cg.BrsSpringBootMVC.service.BRSUserDetailsService;

/**
 * @author Tejaswini
 * Description: Security configuration using Spring Security
 * Created On: 11-10-2019
 *
 */
@EnableWebSecurity
public class BRSWebSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	BRSUserDetailsService userDetailsService;
	
	/**
	 * @author Tejaswini
	 * Description:  Gets the AuthenticationManager to use
	 * Created On: 11-10-2019
	 *
	 */
	@Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
    }
	
	 	/**
	 	 * @author Tejaswini
	 	 * Description: Redirecting to respective pages after login based on the user roles
	 	 * @return an instance of BRSUrlAuthenticationSuccessHandler
	 	 * Created On: 11-10-2019
	 	 */
	 	@Bean
	    public AuthenticationSuccessHandler brsAuthenticationSuccessHandler(){
	        return new BRSUrlAuthenticationSuccessHandler();
	    }
	
	/**
	 * @author Tejaswini
	 * Description: validating username and password from user table
	 * Created on: 11-10-2019
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService);
	}
	
	/**
	 * @author Tejaswini
	 * Description: controls the access of urls based on user roles and session management
	 * Created on :11-10-2019
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		 http.sessionManagement()
	        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
		
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/aboutUs").permitAll()
		.antMatchers("/register").permitAll()
		.antMatchers("/adduser").permitAll()
		.antMatchers("/report").permitAll()
		.antMatchers("/help").permitAll()
		.antMatchers("/addbus").hasRole("ADMIN")
		.antMatchers("/addbusdetails").hasRole("ADMIN")
		.antMatchers("/showbuses").hasRole("ADMIN")
		.antMatchers("/deletebus").hasRole("ADMIN")
		.antMatchers("/showusers").hasRole("ADMIN")
		.antMatchers("/customerhome").hasAnyRole("ADMIN","CUSTOMER")
		.antMatchers("/showrunningbuses").hasAnyRole("ADMIN","CUSTOMER")
		.antMatchers("/addbooking").hasAnyRole("ADMIN","CUSTOMER")
		.antMatchers("/addpassenger").hasAnyRole("ADMIN","CUSTOMER")
		.antMatchers("/addpassengerdetails").hasAnyRole("ADMIN","CUSTOMER")
		.antMatchers("/createbooking").hasAnyRole("ADMIN","CUSTOMER")
		.antMatchers("/cancelbooking").hasAnyRole("ADMIN","CUSTOMER")
		.antMatchers("/confirmation").hasAnyRole("ADMIN","CUSTOMER")
		.antMatchers("/pdetail").hasAnyRole("ADMIN","CUSTOMER")
		.antMatchers("/viewcurrentbooking").hasAnyRole("ADMIN","CUSTOMER")
		.antMatchers("/viewallbookings").permitAll()
		.and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password")
		.successHandler(brsAuthenticationSuccessHandler())
		.and().logout().logoutSuccessUrl("/").and().csrf().disable();
	}
	
	/**
	 * @author Tejaswini
	 * Description: Useful for testing where working with plain text passwords may be preferred.
	 * @return instance of NoOpPasswordEncoder
	 */
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		
	}
	
}
