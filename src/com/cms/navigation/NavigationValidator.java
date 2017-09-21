/**
Copyright Prakash
All rights reserved
 */
package com.cms.navigation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cms.util.GlobalNullChecker;

@Component("navigatoinValidator")
public class NavigationValidator implements Validator {

	@Autowired
	@Qualifier("navigationService")
	NavigationService navigationService;

	public void setNavigationService(NavigationService navigationService) {
		this.navigationService = navigationService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Navigation.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {
		Navigation navigation = (Navigation) target;
		String label = navigation.getLabel();
		String pageOrder = navigation.getPageOrder();
		String title = navigation.getTitle();

		if (label != null && pageOrder != null && title != null) {
			if (GlobalNullChecker.empty(label))
				error.rejectValue("label", "error.label");
			if (GlobalNullChecker.empty(String.valueOf(pageOrder))) {
				error.rejectValue("pageOrder", "error.order");
			}else {
				try {
					int order=Integer.parseInt(pageOrder);
				}catch(NumberFormatException e) {
					error.rejectValue("pageOrder", "error.ordernotnumber");
				}
			}
			if (GlobalNullChecker.empty(title))
				error.rejectValue("title", "error.title");
			
			//if("NONE".equals(navigation.getpid()))
				//error.rejectValue("pid", "error.selectpageid");
		}
	}

}
