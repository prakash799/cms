/**
Copyright Prakash
All rights reserved
*/
package com.cms.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cms.user.User;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger=Logger.getLogger(LoginInterceptor.class);
	
	@Autowired
	HttpSession session;
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		System.out.println("prehandler method");
		User user = (User) session.getAttribute("user");
		String requestURI = request.getRequestURI();
		String substring = requestURI.substring(requestURI.lastIndexOf("/")+1);
		if(substring.equals("/")||substring.equals("login")) {
			return true;
		}else {
			if(user==null) {
				response.sendRedirect("index.jsp");
			}
		}
		return true;
	}	
}
