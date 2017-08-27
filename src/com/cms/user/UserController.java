/**
Copyright Prakash
All rights reserved
*/
package com.cms.user;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.ModelAndView;

import com.cms.security.LoginValidator;
import com.cms.security.RegistrationValidator;
import com.cms.security.UpdateValidator;
import com.cms.util.JasonResponse;

@Controller
public class UserController {
	
	@Autowired
	@Qualifier("updatevalidator")
	UpdateValidator updatevalidator;
	
	@Autowired
	@Qualifier("loginvalidator")
	LoginValidator loginVaildator;
	
	@Autowired
	@Qualifier("userservice")
	UserService userService;
	
	public void setValidator(UpdateValidator updatevalidator) {
		this.updatevalidator = updatevalidator;
	}

	public void setVaildator(LoginValidator loginVaildator) {
		this.loginVaildator = loginVaildator;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@RequestMapping(value="/",method= {RequestMethod.GET,RequestMethod.POST})
	public String openLogin(@ModelAttribute("user")User user) {
		return "login";
	}
	
	@RequestMapping(value= {"login"},method= {RequestMethod.POST,RequestMethod.GET})
	public String doLogin(@ModelAttribute("user")@Valid User user,Model model,BindingResult result,HttpSession session) {
		session.removeAttribute("user");
		System.out.println(user);
		if ((user.getLoginid() != null) && (user.getPassword() != null)) {
			this.loginVaildator.validate(user, result);
			if(result.hasErrors()) {
				return "login";
			}else {
				User u=null;
				try {
					u=this.userService.validateUser(user.getLoginid(), user.getPassword());
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				session.setAttribute("user", u);
				return "admin";
			}
		}
		return "login";
	}
	
	
	@RequestMapping(value= {"showuserdetails"},method= {RequestMethod.GET,RequestMethod.POST})
	public String showUser(@ModelAttribute("user")@Valid User user,Model model,BindingResult result) {
		List<User> allUsers = userService.listAllUsers();
		model.addAttribute("userlist", allUsers);
		return "listAllUsers";
	}
	
	@RequestMapping(value="/delete",method= {RequestMethod.GET,RequestMethod.POST})
	public void deleteUser(@RequestParam(value="id",required=true)long id,HttpServletResponse response) {
		User user = this.userService.getUserById(id);
		this.userService.deleteUser(user);
		try {
			response.sendRedirect("showuserdetails");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value="updateUrl",method= {RequestMethod.POST,RequestMethod.GET})
	public String openUpdatePage(@RequestParam(value="id",required=true)long id, Model model) {
		User userById = this.userService.getUserById(id);
		model.addAttribute("user", userById);
		return "updateuser";
	}
	
	@RequestMapping(value= {"getuserdetails"},method= {RequestMethod.POST,RequestMethod.GET},produces = "application/json")
	public @ResponseBody  User getUserDetails(@RequestParam(value="id",required=true)long id,@ModelAttribute("user")@Valid User user,Model model,BindingResult result,HttpServletResponse response) {
		//String userId=id+"";
		if(id!=0) {
			user = this.userService.getUserById(id);
			}else {
				try {
					response.sendRedirect("showuserdetails");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		return user;
	}
	
	@RequestMapping(value="updateuserdetails",method=RequestMethod.POST)
	public ModelAndView updateUser(@RequestParam(value="id",required=true)long id, @Valid User user,Model model,BindingResult result,HttpServletResponse response){
		user=this.userService.getUserById(id);
		if(user!=null) {
			System.out.println("MODEL------>"+model);
				this.userService.updateUser(user);
		}
		return new ModelAndView("showuserdetails");
	}
	
}
