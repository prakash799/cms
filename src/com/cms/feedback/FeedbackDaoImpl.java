/**
Copyright Prakash
All rights reserved
*/
package com.cms.feedback;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("feedbackdaoimpl")
public class FeedbackDaoImpl implements FeedbackDao{

	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void insertFeedback(Feedback feedback) {
		sessionFactory.getCurrentSession().persist(feedback);
	}

	@Override
	@Transactional
	public void updateFeedback(Feedback feedback) {
		sessionFactory.getCurrentSession().update(feedback);
	}

	@Override
	@Transactional
	public void deleteFeedback(Feedback feedback) {
		Session session = sessionFactory.getCurrentSession();
		feedback= (Feedback) session.load(Feedback.class, feedback.getId());
		if(feedback!=null) {
			session.delete(feedback);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Feedback> listAllFeedback() {
		Session currentSession = this.sessionFactory.getCurrentSession();
		List<Feedback> list = currentSession.createCriteria(Feedback.class).list();
		return list;
	}

}
