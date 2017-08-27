/**
Copyright Prakash
All rights reserved
*/
package com.cms.img_video;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("documentDao")
public class DocumentDaoImpl implements DocumentDao{

	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void insert(DocumentDto document) {
		this.sessionFactory.getCurrentSession().save(document);
	}

	@Override
	@Transactional
	public void update(DocumentDto document) {
		this.sessionFactory.getCurrentSession().update(document);
		
	}

	@Override
	@Transactional
	public void delete(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		DocumentDto docs = (DocumentDto) currentSession.get(DocumentDto.class, id);
		if(docs!=null) {
			currentSession.delete(docs);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DocumentDto> listAllDocument() {
		Session currentSession = this.sessionFactory.getCurrentSession();
		List<DocumentDto> list = currentSession.createCriteria(DocumentDto.class).list();
		return list;
	}

	@Override
	@Transactional
	public DocumentDto getDocById(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		DocumentDto byId = (DocumentDto) currentSession.get(DocumentDto.class, id);
		return byId;
	}
}
