/**
Copyright Prakash
All rights reserved
*/
package com.cms.navigation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cms.page.PageDto;

@Repository("navigationDao")
public class NavigationDaoImpl implements NavigationDao{

	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void insert(long pid,Navigation nav) throws SQLException {
		 Session currentSession = this.sessionFactory.getCurrentSession();
		 currentSession.persist(nav);
		 PageDto existingPage = (PageDto) currentSession.load(PageDto.class, pid);
		 existingPage.getNavigation().add(nav);
		 currentSession.persist(existingPage);
	}

	@Override
	@Transactional
	public void update(Navigation nav) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		Navigation existingNavigation = (Navigation) session.load(Navigation.class, nav.getNavid());
		existingNavigation.setLabel(nav.getLabel());
		existingNavigation.setPageOrder(nav.getPageOrder());
		existingNavigation.setTitle(nav.getTitle());
		session.persist(existingNavigation);
	}

	@Override
	@Transactional
	public void delete(long navid) throws SQLException {
		Session currentSession = sessionFactory.getCurrentSession();
		SQLQuery query = currentSession.createSQLQuery("DELETE FROM PAGE_NAVIGATION WHERE NAVIGATION_ID="+navid);
		query.executeUpdate();
		Navigation nav = (Navigation) currentSession.load(Navigation.class, navid);
		if(nav!=null) {
			currentSession.delete(nav);
		}
	}

	@Override
	@Transactional
	public Navigation select(long id) throws SQLException {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Navigation nav = (Navigation) currentSession.get(Navigation.class, id);
		return nav;
	}

	@Override
	@Transactional
	public Navigation select(int order) throws SQLException {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Navigation nav = (Navigation) currentSession.get(Navigation.class, order);
		return nav;
	}

	@Override
	@Transactional
	public Navigation select(String label) throws SQLException {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Navigation nav = (Navigation) currentSession.get(Navigation.class, label);
		return nav;
	}

	@Override
	@Transactional
	public SortedSet<Navigation> selectByOrder() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Navigation> selectAll(long pid) throws SQLException {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("From PageDto as p WHERE p.pid="+pid);
		PageDto page = (PageDto) query.uniqueResult();
		return new ArrayList<Navigation>(page.getNavigation());
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Navigation> selectAll() throws SQLException {
		Session currentSession = this.sessionFactory.getCurrentSession();
		List<Navigation> list = currentSession.createCriteria(Navigation.class).list();
		return list;
	}
}
