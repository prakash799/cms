/**
Copyright Prakash
All rights reserved
 */
package com.cms.security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("phonevalidator")
public class PhoneNumberValidator {
	
	public static boolean isValidPhoneNumber(String phone) {
		Pattern compile = Pattern.compile("\\d{10}");
		Matcher matcher = compile.matcher(phone);
		return matcher.matches();
	}
}
