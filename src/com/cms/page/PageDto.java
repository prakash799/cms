/**
Copyright Prakash
All rights reserved
 */
package com.cms.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.cms.navigation.Navigation;

@Entity
@Table(name = "page")
public class PageDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PAGE_ID")
	private long pid;

	@Column(name = "PAGE_NAME")
	private String pageName;

	@Column(name = "PAGE_TITLE")
	private String pageTitle;

	@Lob
	@Column(name = "PAGE_BODY")
	private String pageBody;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "PAGE_NAVIGATION", joinColumns = @JoinColumn(name = "PAGE_ID"), inverseJoinColumns = @JoinColumn(name = "NAVIGATION_ID"))
	private Set<Navigation> navigation;

	public PageDto() {
		super();
	}

	public PageDto(long pid, String pageName, String pageTitle,
			String pageBody, Set<Navigation> navigation) {
		super();
		this.pid = pid;
		this.pageName = pageName;
		this.pageTitle = pageTitle;
		this.pageBody = pageBody;
		this.navigation = navigation;
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

	public Set<Navigation> getNavigation() {
		return navigation;
	}

	public void setNavigation(Set<Navigation> navigation) {
		this.navigation = navigation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((navigation == null) ? 0 : navigation.hashCode());
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
		if (navigation == null) {
			if (other.navigation != null)
				return false;
		} else if (!navigation.equals(other.navigation))
			return false;
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
				+ ", pageTitle=" + pageTitle + ", pageBody=" + pageBody
				+ ", navigation=" + navigation + "]";
	}

}
