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
		
		if (loginid != null && password != null) {
				if((loginid.trim().equals(""))||(password.trim().equals(""))) {
					error.rejectValue("loginid", "error.loginidlogin");
				}else if(!(loginid.trim().equals(""))||!(password.trim().equals(""))) {
					try {
						User userById = userService.validateUser(loginid, password);
						if(userById==null) {
							error.rejectValue("loginid", "error.invaildcredentials");
						}
					}catch(NumberFormatException e) {
							error.rejectValue("loginid", "error.loginidnotNumber");
					} catch (NoSuchAlgorithmException e) {
						e.printStackTrace();
					}catch(NullPointerException e) {
						error.rejectValue("loginid", "error.usernotexists");
					}
				}
			}
		
	}

}
