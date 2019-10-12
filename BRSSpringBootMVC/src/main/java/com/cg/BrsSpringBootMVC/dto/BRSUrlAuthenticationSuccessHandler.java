package com.cg.BrsSpringBootMVC.dto;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.cg.BrsSpringBootMVC.dao.UserRepository;


public class BRSUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserRepository userRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(BRSUrlAuthenticationSuccessHandler.class);

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		String username="";
		
		if(authentication.getPrincipal() instanceof Principal) {
			username=((Principal)authentication.getPrincipal()).getName();
		}else {
			username=((BRSUserDetails)authentication.getPrincipal()).getUsername();
		}
		
		System.out.println("username: "+username);
		
		session.setAttribute("username", username);
		
		 handle(request, response, authentication);
	        clearAuthenticationAttributes(request);

	}
	
	 protected void handle(HttpServletRequest request, 
		      HttpServletResponse response, Authentication authentication)
		      throws IOException {
		  
		        String targetUrl = determineTargetUrl(authentication);
		 
		        if (response.isCommitted()) {
		            logger.debug(
		              "Response has already been committed. Unable to redirect to "
		              + targetUrl);
		            return;
		        }
		 
		        redirectStrategy.sendRedirect(request, response, targetUrl);
		    }
	 protected String determineTargetUrl(Authentication authentication) {
	        boolean isUser = false;
	        boolean isAdmin = false;
	        Collection<? extends GrantedAuthority> authorities
	         = authentication.getAuthorities();
	        for (GrantedAuthority grantedAuthority : authorities) {
	            if (grantedAuthority.getAuthority().equals("ROLE_CUSTOMER")) {
	                isUser = true;
	                break;
	            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
	                isAdmin = true;
	                break;
	            }
	        }
	 
	        if (isUser) {
	            return "/customerhome";
	        } else if (isAdmin) {
	            return "/adminhome";
	        } else {
	            throw new IllegalStateException();
	        }
	    }
	 
	 protected void clearAuthenticationAttributes(HttpServletRequest request) {
	        HttpSession session = request.getSession(false);
	        if (session == null) {
	            return;
	        }
	        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	    }
	 
	    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
	        this.redirectStrategy = redirectStrategy;
	    }
	    protected RedirectStrategy getRedirectStrategy() {
	        return redirectStrategy;
	    }

}
