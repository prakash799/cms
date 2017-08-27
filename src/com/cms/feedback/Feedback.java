/**
Copyright Prakash
All rights reserved
 */
package com.cms.feedback;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="USER_NAME")
	private String username;
	@Column(name="USER_EMAIL")
	private String useremail;
	@Column(name="USER_PHONE")
	private String userphone;
	@Column(name="USER_FEEDBACK")
	private String userfeedback;

	public Feedback(long id, String username, String useremail,
			String userphone, String userfeedback) {
		super();
		this.id = id;
		this.username = username;
		this.useremail = useremail;
		this.userphone = userphone;
		this.userfeedback = userfeedback;
	}

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getUserfeedback() {
		return userfeedback;
	}

	public void setUserfeedback(String userfeedback) {
		this.userfeedback = userfeedback;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((useremail == null) ? 0 : useremail.hashCode());
		result = prime * result
				+ ((userfeedback == null) ? 0 : userfeedback.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		result = prime * result
				+ ((userphone == null) ? 0 : userphone.hashCode());
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
		Feedback other = (Feedback) obj;
		if (id != other.id)
			return false;
		if (useremail == null) {
			if (other.useremail != null)
				return false;
		} else if (!useremail.equals(other.useremail))
			return false;
		if (userfeedback == null) {
			if (other.userfeedback != null)
				return false;
		} else if (!userfeedback.equals(other.userfeedback))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (userphone == null) {
			if (other.userphone != null)
				return false;
		} else if (!userphone.equals(other.userphone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", username=" + username + ", useremail="
				+ useremail + ", userphone=" + userphone + ", userfeedback="
				+ userfeedback + "]";
	}

}
