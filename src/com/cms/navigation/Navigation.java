/**
Copyright Prakash
All rights reserved
 */
package com.cms.navigation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cms.page.PageDto;

@Entity
@Table(name = "navigation")
public class Navigation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NAVIGATION_ID")
	private long navid;

	@Column(name = "PAGE_ORDER")
	private String pageOrder;

	@Column(name = "LABEL")
	private String label;

	@Column(name = "TITLE")
	private String title;

	private long pid;

	public Navigation() {
		super();
	}

	public Navigation(long navid, String pageOrder, String label, String title,
			long pid) {
		super();
		this.navid = navid;
		this.pageOrder = pageOrder;
		this.label = label;
		this.title = title;
		this.pid = pid;
	}

	public long getNavid() {
		return navid;
	}

	public void setNavid(long navid) {
		this.navid = navid;
	}

	public String getPageOrder() {
		return pageOrder;
	}

	public void setPageOrder(String pageOrder) {
		this.pageOrder = pageOrder;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + (int) (navid ^ (navid >>> 32));
		result = prime * result
				+ ((pageOrder == null) ? 0 : pageOrder.hashCode());
		result = prime * result + (int) (pid ^ (pid >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Navigation other = (Navigation) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (navid != other.navid)
			return false;
		if (pageOrder == null) {
			if (other.pageOrder != null)
				return false;
		} else if (!pageOrder.equals(other.pageOrder))
			return false;
		if (pid != other.pid)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Navigation [navid=" + navid + ", pageOrder=" + pageOrder
				+ ", label=" + label + ", title=" + title + ", pid=" + pid
				+ "]";
	}

}
