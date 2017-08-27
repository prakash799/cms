/**
Copyright Prakash
All rights reserved
*/
package com.cms.page;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cms.user.User;

@Controller
public class PageController {

	@Autowired
	@Qualifier("pagevaildator")
	PageValidator PageValidator;
	
	@Autowired
	@Qualifier("pageserviceimpl")
	PageService pageService; 
	
	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}

	public void setPageValidator(PageValidator pageValidator) {
		PageValidator = pageValidator;
	}

	@RequestMapping(value= {"createnewpage"},method= {RequestMethod.GET,RequestMethod.POST})
	public String viewPage(@ModelAttribute("pg")PageDto pageDto, Model model) {
		return "createPage";
	}
	
	
	@RequestMapping(value= {"submitcreatedpage"},method= {RequestMethod.POST,RequestMethod.GET})
	public String createNewPage(@ModelAttribute("pg")@Valid PageDto pageDto,Model model,BindingResult result) {
		if (pageDto.getPageName() != null && pageDto.getPageTitle() != null) {
			this.PageValidator.validate(pageDto, result);
			if(result.hasErrors()) {
				return "createPage";
			}else {
				this.pageService.insertPage(pageDto);
				return "listAllPages";
			}
		}
		return "createPage";
	}
	
	
	@RequestMapping(value= {"showallpages"},method=RequestMethod.GET)
	public String showUser(@ModelAttribute("pg")PageDto pg,Model model) {
		List<PageDto> allPages = pageService.selectAllPage();
		model.addAttribute("allpages", allPages);
		return "listAllPages";
	}
	
}
