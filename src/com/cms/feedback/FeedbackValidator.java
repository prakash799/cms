/**
Copyright Prakash
All rights reserved
*/
package com.cms.feedback;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cms.security.EmailValidator;
import com.cms.security.PhoneNumberValidator;
import com.cms.util.GlobalNullChecker;

@Component("feedbackvalidator")
public class FeedbackValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Feedback.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {
		Feedback feedback=(Feedback) target;
		String username = feedback.getUsername();
		String userphone = feedback.getUserphone();
		String useremail = feedback.getUseremail();
		String userfeedback = feedback.getUserfeedback();
		
		if(GlobalNullChecker.empty(username)) {
			error.rejectValue("username", "error.feedbackusername");
		}else if(username.length()<3||username.length()>25) {
			error.rejectValue("username", "error.impropername");
		}
			
		if(GlobalNullChecker.empty(userphone)) {
			error.rejectValue("userphone", "error.feedbackuserphone");
		}else if(!PhoneNumberValidator.isValidPhoneNumber(userphone)) {
			error.rejectValue("userphone", "error.invalidPhone");
		}
		
		if(GlobalNullChecker.empty(useremail)) {
			error.rejectValue("useremail", "error.feedbackuseremail");
		}else if(!EmailValidator.doEmailValidation(useremail)) {
			error.rejectValue("useremail", "error.invalidemail");
		}
			
		if(GlobalNullChecker.empty(userfeedback))
			error.rejectValue("userfeedback", "error.feedbackuserfeedback");
	}

}
