/**
Copyright Prakash
All rights reserved
 */
package com.cms.navigation;

import java.sql.SQLException;
import java.util.List;
import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.page.PageDto;
import com.cms.page.PageServiceImpl;

@Service("navigationService")
public class NaviagtionServiceImpl implements NavigationService {

	@Autowired
	@Qualifier("navigationDao")
	NavigationDao navigationDao;

	@Autowired
	@Qualifier("pageserviceimpl")
	PageServiceImpl pageServiceImpl;
	
	public void setPageServiceImpl(PageServiceImpl pageServiceImpl) {
		this.pageServiceImpl = pageServiceImpl;
	}

	public void setNavigationDao(NavigationDao navigationDao) {
		this.navigationDao = navigationDao;
	}

	@Override
	public void createNavigation(long pid,Navigation nav) throws SQLException {
		this.navigationDao.insert(pid, nav);
	}

	@Override
	public void updateNavigation(Navigation nav) throws SQLException {
		this.navigationDao.update(nav);
	}

	@Override
	public void removeNavigation(long navid) throws SQLException {
		this.navigationDao.delete(navid);
	}

	@Override
	public Navigation getNav(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Navigation getNav(int order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Navigation getNav(String label) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Navigation> getAll(long pid) throws SQLException {
		return this.navigationDao.selectAll(pid);
	}

	@Override
	public SortedSet<Navigation> getAllSorted() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageDto getPage(long navid) {
		this.pageServiceImpl.selectPageById(navid);
		return null;
	}

}
