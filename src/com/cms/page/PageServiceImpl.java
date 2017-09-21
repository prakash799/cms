/**
Copyright Prakash
All rights reserved
*/
package com.cms.page;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pageserviceimpl")
public class PageServiceImpl implements PageService{

	@Autowired
	@Qualifier("pagedaoimpl")
	PageDao pageDao;
	
	public void setPageDao(PageDao pageDao) {
		this.pageDao = pageDao;
	}

	@Override
	public void insertPage(PageDto page) {
		this.pageDao.insertPage(page);
	}

	@Override
	public void updatePage(PageDto page) {
		this.pageDao.updatePage(page);
	}

	@Override
	public void deletePage(PageDto page) {
		this.pageDao.deletePage(page);
	}

	@Override
	public PageDto selectPageById(long pid) {
		PageDto selectPageById = this.pageDao.selectPageById(pid);
		Hibernate.initialize(selectPageById);
		return selectPageById;
	}

	@Override
	public PageDto selectPageByName(String pageName) {
		PageDto selectPageByName = this.pageDao.selectPageByName(pageName);
		return selectPageByName;
	}

	@Override
	public List<PageDto> selectAllPage() {
		List<PageDto> selectAllPage = this.pageDao.selectAllPage();
		return selectAllPage;
	}

	@Override
	public Map<Long, String> selectAll() throws SQLException {
		Map<Long, String> selectAll = this.pageDao.selectAll();
		return selectAll;
	}

	@Override
	public PageDto vaildatePage(String pageName) {
		// TODO Auto-generated method stub
		return null;
	}
		
}
