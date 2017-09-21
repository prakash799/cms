/**
Copyright Prakash
All rights reserved
*/
package com.cms.page;

import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

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
				return "redirect:/showallpages";
			}
		}
		return "createPage";
	}
	
	
	@RequestMapping(value= {"showallpages"},method=RequestMethod.GET)
	public String showAllPages(@ModelAttribute("pg")PageDto pg,Model model,HttpSession session) {
		List<PageDto> allPages = pageService.selectAllPage();
		model.addAttribute("allpages", allPages);
		return "listAllPages";
	}
	@RequestMapping(value= {"page"},method=RequestMethod.GET)
	public String showPageTemplate(@RequestParam long id,Model model,HttpSession session) {
		PageDto page=pageService.selectPageById(id);
		System.out.println(page);
		model.addAttribute("page", page);
		return "page_template";
	}
	
	@RequestMapping(value= {"deletepage"},method= {RequestMethod.POST,RequestMethod.GET})
	public String deletePage(@RequestParam long id,HttpServletResponse response) throws IOException {
		PageDto page = this.pageService.selectPageById(id);
		this.pageService.deletePage(page);
		return "redirect:/showallpages";
	}
	
	@RequestMapping(value= {"editpage"},method= {RequestMethod.POST,RequestMethod.GET})
	public String editPage(@RequestParam long id,Model model) throws IOException {
		PageDto page = this.pageService.selectPageById(id);
		model.addAttribute("page", page);
		return "update_page";
	}
	
	@RequestMapping(value= {"udpatepage"},method= {RequestMethod.POST,RequestMethod.GET})
	public String udpatePage(@ModelAttribute("page")@Valid PageDto pageDto,Model model,BindingResult result) throws IOException {
		if(pageDto!=null) {
			this.PageValidator.validate(pageDto, result);
			if(result.hasErrors()) {
				return "update_page";
			}else {
				System.out.println(pageDto.getPid());
				this.pageService.updatePage(pageDto);
				return "redirect:/showallpages"; 
			}
		}
		return "update_page";
	}
}
