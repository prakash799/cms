/**
Copyright Prakash
All rights reserved
 */
package com.cms.page;

import java.util.List;
import java.util.Map;

public interface PageService {

	public void insertPage(PageDto page);

	public PageDto selectPageById(long pid);

	public List<PageDto> selectAllPage();
}
