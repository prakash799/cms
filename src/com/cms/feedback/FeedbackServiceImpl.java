/**
Copyright Prakash
All rights reserved
*/
package com.cms.feedback;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("feedbackserviceimpl")
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	@Qualifier("feedbackdaoimpl")
	FeedbackDao feedbackDao;
	
	public void setFeedbackDao(FeedbackDao feedbackDao) {
		this.feedbackDao = feedbackDao;
	}

	@Override
	public void insertFeedback(Feedback feedback) {
		feedbackDao.insertFeedback(feedback);
	}

	@Override
	public void updateFeedback(Feedback feedback) {
		feedbackDao.updateFeedback(feedback);
		
	}

	@Override
	public void deleteFeedback(Feedback feedback) {
		feedbackDao.deleteFeedback(feedback);
		
	}

	@Override
	public List<Feedback> listAllFeedback() {
		List<Feedback> listAllPage = feedbackDao.listAllFeedback();
		return listAllPage;
	}

}
