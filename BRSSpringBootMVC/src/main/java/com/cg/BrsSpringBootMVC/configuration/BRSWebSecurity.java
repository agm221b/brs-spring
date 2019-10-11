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
		.antMatchers("/").permitAll()
		.antMatchers("/aboutUs").permitAll()
		.antMatchers("/register").permitAll()
		.antMatchers("/adduser").permitAll()
		.antMatchers("/report").permitAll()
		.antMatchers("/help").permitAll()
		.antMatchers("/addbus").permitAll()
		.antMatchers("/addbusdetails").permitAll()
		.antMatchers("/showbuses").permitAll()
		.antMatchers("/deletebus").permitAll()
		.antMatchers("/showusers").permitAll()
		.antMatchers("/customerhome").permitAll()
		.antMatchers("/showrunningbuses").permitAll()
		.antMatchers("/addbooking").permitAll()
		.antMatchers("/addpassenger").permitAll()
		.antMatchers("/addpassengerdetails").permitAll()
		.antMatchers("/createbooking").permitAll()
		.antMatchers("/cancelbooking").permitAll()
		.antMatchers("/confirmation").permitAll()
		.antMatchers("/pdetail").permitAll()
		.antMatchers("/viewcurrentbooking").permitAll()
		.antMatchers("/viewallbookings").permitAll()
		.and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password")
		.successHandler(brsAuthenticationSuccessHandler())
		.and().logout().logoutSuccessUrl("/");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
