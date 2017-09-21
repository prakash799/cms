/**
Copyright Prakash
All rights reserved
 */
package com.cms.security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component("emailvalidator")
public class EmailValidator {

	private static Pattern pattern;
	private static Matcher matcher;
	
	private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

	public static boolean doEmailValidation(String email) {
		pattern = Pattern.compile(EMAIL_PATTERN,Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
