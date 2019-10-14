package com.cg.BRSSpringRest.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cg.BRSSpringRest.service.BRSUserDetailsService;

@EnableWebSecurity
public class BRSWebSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	BRSUserDetailsService userDetailsService;
	
	@Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
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
		.antMatchers("/viewallbookings").hasRole("CUSTOMER")
		.and().formLogin()
		.and().logout();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		
	}

}