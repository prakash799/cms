/**
Copyright Prakash
All rights reserved
*/
package com.cms.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cms.security.RegistrationValidator;

@Controller
public class RegistrationController {

	@Autowired
	@Qualifier("registrationvalidator")
	RegistrationValidator validator;
	
	@Autowired
	@Qualifier("userservice")
	UserService userService;
	
	public void setValidator(RegistrationValidator validator) {
		this.validator = validator;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="registration",method=RequestMethod.GET)
	public String openRegistration(@ModelAttribute("user")User user) {
		return "registration";
	}
	
	@RequestMapping(value= {"processregistration"},method= {RequestMethod.POST,RequestMethod.GET})
	public  String doRegistration(@ModelAttribute("user")@Valid User user,Model model,BindingResult result,HttpSession session,HttpServletResponse response) {
		session.removeAttribute("user");
		if((user.getName())!=null||user.getEmail()!=null||user.getPhone()!=null||user.getPassword()!=null||user.getLoginid()!=null) {
			this.validator.validate(user, result);
			if(result.hasErrors()) {
				return "registration";
			}else {
				this.userService.insertUser(user);
				try {
					response.sendRedirect("showuserdetails");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "registration";
	}
	
	
	
}
