/**
Copyright Prakash
All rights reserved
 */
package com.cms.page;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "page")
public class PageDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pid;
	@Column(name="PAGE_NAME")
	private String pageName;
	@Column(name="PAGE_TITLE")
	private String pageTitle;
	@Column(name="PAGE_BODY")
	private String pageBody;

	public PageDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageDto(long pid, String pageName, String pageTitle, String pageBody) {
		super();
		this.pid = pid;
		this.pageName = pageName;
		this.pageTitle = pageTitle;
		this.pageBody = pageBody;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getPageBody() {
		return pageBody;
	}

	public void setPageBody(String pageBody) {
		this.pageBody = pageBody;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((pageBody == null) ? 0 : pageBody.hashCode());
		result = prime * result
				+ ((pageName == null) ? 0 : pageName.hashCode());
		result = prime * result
				+ ((pageTitle == null) ? 0 : pageTitle.hashCode());
		result = prime * result + (int) (pid ^ (pid >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageDto other = (PageDto) obj;
		if (pageBody == null) {
			if (other.pageBody != null)
				return false;
		} else if (!pageBody.equals(other.pageBody))
			return false;
		if (pageName == null) {
			if (other.pageName != null)
				return false;
		} else if (!pageName.equals(other.pageName))
			return false;
		if (pageTitle == null) {
			if (other.pageTitle != null)
				return false;
		} else if (!pageTitle.equals(other.pageTitle))
			return false;
		if (pid != other.pid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PageDto [pid=" + pid + ", pageName=" + pageName
				+ ", pageTitle=" + pageTitle + ", pageBody=" + pageBody + "]";
	}

}
