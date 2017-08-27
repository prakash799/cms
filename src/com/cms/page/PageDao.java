/**
Copyright Prakash
All rights reserved
 */
package com.cms.page;

import java.util.List;
import java.util.Map;

public interface PageDao {

	public void insertPage(PageDto page);

	public void updatePage(PageDto page);

	public void deletePage(PageDto page);

	public PageDto selectPageById(long pid);

	public List<PageDto> selectAllPage();
}
