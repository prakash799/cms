/**
Copyright Prakash
All rights reserved
*/
package com.cms.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sun.java2d.pipe.ValidatePipe;

import com.cms.util.GlobalNullChecker;

@Component("pagevaildator")
public class PageValidator implements Validator{

	@Autowired
	@Qualifier("pageserviceimpl")
	PageService service;
	
	public void setService(PageService service) {
		this.service = service;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return PageDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {
		PageDto page=(PageDto) target;
		long pid = page.getPid();
		String pageName = page.getPageName();
		String pageTitle = page.getPageTitle();
		String pageBody = page.getPageBody();
		
		if(pageName!=null||pageTitle!=null||pageBody!=null) {
			
			if(GlobalNullChecker.empty(pageName)) {
				error.rejectValue("pageName", "error.pagename");
			}
			
			if(GlobalNullChecker.empty(pageTitle)) {
				error.rejectValue("pageTitle", "error.pagetitle");
			}
			if(GlobalNullChecker.empty(pageBody))
				error.rejectValue("pageBody", "error.pagebody");
			
			
			page = service.selectPageByName(pageName);
			if(!GlobalNullChecker.isNullObject(page)) {
				error.rejectValue("pageName", "error.pageAlreadyexists");
			}
			
			
			
		}
		
	}

	
}
