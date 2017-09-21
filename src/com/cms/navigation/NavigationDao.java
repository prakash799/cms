/**
Copyright Prakash
All rights reserved
*/
package com.cms.navigation;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

import com.cms.page.PageDto;


public interface NavigationDao {
	
	public void insert(long pid,Navigation nav) throws SQLException;

	public void update(Navigation nav) throws SQLException;

	public void delete(long navid) throws SQLException;

	public Navigation select(long id) throws SQLException;

	public Navigation select(int order) throws SQLException;

	public Navigation select(String label) throws SQLException;
	
	public SortedSet<Navigation> selectByOrder() throws SQLException;

	public List<Navigation> selectAll(long pid) throws SQLException;
	
	
}
