package com.fx21044.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fx21044.model.User;
import com.fx21044.service.UserService;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
	private UserService userService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String userName = authentication.getName();
		
		System.out.println("userName=" + userName);
		
		User theUser = userService.findUserByUserName(userName);
		
		HttpSession session = request.getSession();
		session.setAttribute("user", theUser);
		
		
		response.sendRedirect(request.getContextPath()	+ "/homepage");
	}

}