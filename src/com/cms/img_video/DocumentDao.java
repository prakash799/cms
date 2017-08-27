/**
Copyright Prakash
All rights reserved
 */
package com.cms.img_video;

import java.util.List;

public interface DocumentDao {

	public void insert(DocumentDto document);

	public void update(DocumentDto document);

	public void delete(long id);
	
	public List<DocumentDto> listAllDocument();
	
	public DocumentDto getDocById(long id);
}
