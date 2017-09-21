/**
Copyright Prakash
All rights reserved
 */
package com.cms.navigation;

import java.sql.SQLException;
import java.util.List;
import java.util.SortedSet;

import com.cms.page.PageDto;

public interface NavigationService {

	public void createNavigation(long pid,Navigation nav) throws SQLException;

	public void updateNavigation(Navigation nav) throws SQLException;

	public void removeNavigation(long navid) throws SQLException;

	public Navigation getNav(long id) throws SQLException;

	public Navigation getNav(int order) throws SQLException;

	public Navigation getNav(String label) throws SQLException;

	public List<Navigation> getAll(long pid) throws SQLException;

	public SortedSet<Navigation> getAllSorted() throws SQLException;
	
	public PageDto getPage(long navid);

}
