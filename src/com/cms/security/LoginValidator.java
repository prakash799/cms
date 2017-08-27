/**
Copyright Prakash
All rights reserved
*/
package com.cms.security;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cms.user.User;
import com.cms.user.UserService;
import com.cms.util.GlobalNullChecker;

@Component("loginvalidator")
public class LoginValidator implements Validator{

	@Autowired
	@Qualifier("userservice")
	UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {
		User user=(User) target;
		String loginid = user.getLoginid();
		String password = user.getPassword();
		
		if (loginid.trim().equals("")||password.trim().equals("")) {
			User validateUser=null;
			try {
				validateUser = userService.validateUser(loginid, password);
				if(GlobalNullChecker.empty(loginid)) {
					error.rejectValue("loginid", "error.loginid");
				}else if (validateUser==null) {
					error.rejectValue("loginid", "error.notexisted"); 
				}
			} catch (NoSuchAlgorithmException e) {
				
			}catch (NumberFormatException e) {
				error.rejectValue("loginid", "error.loginidnotNumber");
			}
			
			
			
			
			if(GlobalNullChecker.empty(password))
				error.rejectValue("password", "error.password");
		}
		
	}

}
