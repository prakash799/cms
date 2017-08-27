/**
Copyright Prakash
All rights reserved
 */
package com.cms.security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cms.user.User;
import com.cms.user.UserDao;
import com.cms.user.UserService;
import com.cms.util.GlobalNullChecker;

@Component("updatevalidator")
public class UpdateValidator implements Validator {

	@Autowired
	@Qualifier("userservice")
	UserService userService;
	
	@Autowired
	@Qualifier("userdao")
	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {
		User user = (User) target;
		String email = user.getEmail();
		String name = user.getName();
		String password = user.getPassword();
		String phone = user.getPhone();

		if (GlobalNullChecker.empty(name)) {
			error.rejectValue("name", "error.username");
		} else if (name.length() < 3 || name.length() > 20) {
			error.rejectValue("name", "error.impropername");
		}
		if (GlobalNullChecker.empty(password))
			error.rejectValue("password", "error.password");

		if (GlobalNullChecker.empty(email)) {
			error.rejectValue("email", "error.email");
		} else if (!EmailValidator.doEmailValidation(email)) {
			error.rejectValue("email", "error.invalidemail");
		}

		if (GlobalNullChecker.empty(phone)) {
			error.rejectValue("phone", "error.phone");
		} else if (!PhoneNumberValidator.isValidPhoneNumber(phone)) {
			error.rejectValue("phone", "error.invalidPhone");
		}
	}
}
