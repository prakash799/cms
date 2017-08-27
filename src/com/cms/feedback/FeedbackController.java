/**
Copyright Prakash
All rights reserved
*/
package com.cms.feedback;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FeedbackController {

	@Autowired
	@Qualifier("feedbackserviceimpl")
	FeedbackService feedbackService;
	
	
	@Autowired
	@Qualifier("feedbackvalidator")
	FeedbackValidator feedbackValidator;
	
	
	public void setFeedbackValidator(FeedbackValidator feedbackValidator) {
		this.feedbackValidator = feedbackValidator;
	}

	public void setFeedbackService(FeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}

	@RequestMapping(value= {"openfeedbackform"},method= {RequestMethod.GET,RequestMethod.POST})
	public String openFeedback(@ModelAttribute("userfeedback")Feedback feedback) {
		return "feedback";
	}
	
	@RequestMapping(value= {"submitfeedback"},method= {RequestMethod.GET,RequestMethod.POST})
	public String submitFeedback(@ModelAttribute("userfeedback")@Valid Feedback feedback,BindingResult result) {
		this.feedbackValidator.validate(feedback, result);
		if(result.hasErrors()) {
			return "feedback";
		}else {
			this.feedbackService.insertFeedback(feedback);
			return "list_feedback";
		}
	}
	
	@RequestMapping(value= {"showfeedbacklist"},method= {RequestMethod.GET,RequestMethod.POST})
	public String showAllFeedback(@ModelAttribute("userfeedback")Feedback feedback,Model model) {
		List<Feedback> listAllFeedback = this.feedbackService.listAllFeedback();
		model.addAttribute("listfeedback", listAllFeedback);
		return "list_feedback";
	}
}
