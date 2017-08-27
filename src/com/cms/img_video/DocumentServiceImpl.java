/**
Copyright Prakash
All rights reserved
*/
package com.cms.img_video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("documentService")
public class DocumentServiceImpl implements DocumentService{

	@Autowired
	@Qualifier("documentDao")
	DocumentDao documentDao;
	
	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}

	@Override
	public void insert(DocumentDto document) {
		this.documentDao.insert(document);
	}

	@Override
	public void update(DocumentDto document) {
		this.documentDao.update(document);
		
	}

	@Override
	public void delete(long id) {
		this.documentDao.delete(id);
		
	}

	@Override
	public List<DocumentDto> listAllDocument() {
		List<DocumentDto> documents = this.documentDao.listAllDocument();
		return documents;
	}

	@Override
	public DocumentDto getDocById(long id) {
		DocumentDto docById = this.documentDao.getDocById(id);
		return docById;
	}

}
