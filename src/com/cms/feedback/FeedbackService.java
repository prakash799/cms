/**
Copyright Prakash
All rights reserved
 */
package com.cms.feedback;

import java.util.List;

public interface FeedbackService {

	public void insertFeedback(Feedback feedback);

	public void updateFeedback(Feedback feedback);

	public void deleteFeedback(Feedback feedback);

	public List<Feedback> listAllFeedback();
}
