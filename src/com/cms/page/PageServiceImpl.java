/**
Copyright Prakash
All rights reserved
*/
package com.cms.page;

import java.util.List;

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
		pageDao.insertPage(page);
	}

	@Override
	public PageDto selectPageById(long pid) {
		PageDto byId = pageDao.selectPageById(pid);
		return byId;
	}

	@Override
	public List<PageDto> selectAllPage() {
		return pageDao.selectAllPage();
	}
	
	public static void main(String[] args) {
		PageDaoImpl daoImpl = new PageDaoImpl();
		PageDto id = daoImpl.selectPageById(1);
		System.out.println(id);
	}
		
}
