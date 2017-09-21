/**
Copyright Prakash
All rights reserved
*/
package com.cms.navigation;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import com.cms.page.PageDto;
import com.cms.page.PageService;
import com.cms.page.PageServiceImpl;

@Controller
public class NavigationController {

	@Autowired
	@Qualifier("navigatoinValidator")
	NavigationValidator navigationValidator;
	
	@Autowired
	@Qualifier("navigationService")
	NavigationService navigationService;
	
	@Autowired
	PageService pageService;
	
	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}

	public void setNavigationValidator(NavigationValidator navigationValidator) {
		this.navigationValidator = navigationValidator;
	}
	
	public void setNavigationService(NavigationService navigationService) {
		this.navigationService = navigationService;
	}



	@SuppressWarnings("unchecked")
	@RequestMapping(value="opennavigation",method= {RequestMethod.GET,RequestMethod.POST})
	public String openNaviagtion(@ModelAttribute("nav")Navigation navigatoin,Model model) throws SQLException {
		Map<Long, String> map = this.pageService.selectAll();
		System.out.println(map);
			model.addAttribute("map", map);
		
		return "create_naviagatoin";
	}
	
	@RequestMapping(value= {"createnav"},method= {RequestMethod.GET,RequestMethod.POST})
	public String createNavigation(@ModelAttribute("nav")@Valid Navigation navigation,BindingResult result) throws SQLException {
		if(navigation!=null) {
			//System.out.println(navigation);
			this.navigationValidator.validate(navigation, result);
			if(result.hasErrors()) {
				return "create_naviagatoin";
			}else {
				
				return "listnavigation";
			}
		}
		return "listnavigation";
	}
}
