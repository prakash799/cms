/**
Copyright Prakash
All rights reserved
*/
package com.cms.user;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Qualifier("userdao")
public class UserDaoImpl implements UserDao{

	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void insertUser(User user) {
		sessionFactory.getCurrentSession().persist(user);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		 Session session = sessionFactory.getCurrentSession();
		 user=(User)session.get(User.class, user.getId());
		 if(user!=null) {
			 session.delete(user);
		 }
	}

	@Override
	@Transactional
	public User getUserById(long id){
		Session currentSession = sessionFactory.getCurrentSession();
		User user = (User)currentSession.get(User.class, id);
		return user;
	}
	

	@Override
	@Transactional
	public User validateUser(String loginid) {
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(User.class).add(Restrictions.eq("loginid", loginid.trim()));
		User user = (User) criteria.uniqueResult();
		return user;
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<User> listAllUsers() {
		Session currentSession = sessionFactory.getCurrentSession();
		List<User> list = currentSession.createCriteria(User.class).list();
		return list;
	}
}
