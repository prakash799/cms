/**
Copyright Prakash
All rights reserved
*/
package com.cms.page;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("pagedaoimpl")
public class PageDaoImpl implements PageDao{

	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void insertPage(PageDto page) {
		sessionFactory.getCurrentSession().persist(page);
	}

	@Override
	@Transactional
	public void updatePage(PageDto page) {
		sessionFactory.getCurrentSession().update(page);
	}

	@Override
	@Transactional
	public void deletePage(PageDto page) {
		Session session = sessionFactory.getCurrentSession();
		page =(PageDto) session.load(PageDto.class, page.getPid());
		if(page!=null) {
			session.delete(page);
		}
	}

	@Override
	@Transactional
	public PageDto selectPageById(long pid) {
		Session currentSession = sessionFactory.getCurrentSession();
		PageDto page = (PageDto) currentSession.load(PageDto.class, pid);
		currentSession.flush();
		currentSession.clear();
		return page;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PageDto> selectAllPage() {
		Session currentSession = this.sessionFactory.getCurrentSession();
		List<PageDto> list = currentSession.createCriteria(PageDto.class).list();
		return list;
	}
	
}
