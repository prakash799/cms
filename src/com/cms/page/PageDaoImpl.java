/**
Copyright Prakash
All rights reserved
*/
package com.cms.page;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cms.navigation.Navigation;

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
		Session session = sessionFactory.getCurrentSession();
		PageDto existingPage = (PageDto) session.load(PageDto.class, page.getPid());
		existingPage.setPid(page.getPid());
		existingPage.setPageName(page.getPageName());
		existingPage.setPageTitle(page.getPageTitle());
		existingPage.setPageBody(page.getPageBody());
		session.update(existingPage);
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
		Hibernate.initialize(page);
		return page;
	}

	@Override
	@Transactional
	public PageDto vaildatePage(String pageName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(PageDto.class).add(Restrictions.eq("pageName", pageName));
		PageDto pageDto = (PageDto) criteria.uniqueResult();
		return pageDto;
	}

	@Override
	@Transactional
	public PageDto selectPageByName(String pageName) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Criteria criteria =  currentSession.createCriteria(PageDto.class).add(Restrictions.eq("pageName", pageName));
		PageDto page = (PageDto) criteria.uniqueResult();
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

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Map<Long, String> selectAll() throws SQLException {
		String query="select pid,pageName from PageDto";
		Session currentSession = this.sessionFactory.getCurrentSession();
		List<List<Object>> PageDto = currentSession.createQuery(query).setResultTransformer(Transformers.TO_LIST).list();
		Map<Long,String> map = new HashMap<>();
		for(List<Object>page:PageDto) {
			map.put((Long)page.get(0), (String)page.get(1));
		}
		return map;
	}
	
	public static void main(String[] args) throws SQLException {
		List<PageDto> list = new PageDaoImpl().selectAllPage();
		System.out.println(list);
	}
}
