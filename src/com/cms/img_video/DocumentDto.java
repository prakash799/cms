/**
Copyright Prakash
All rights reserved
 */
package com.cms.img_video;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "docs_data")
public class DocumentDto implements Serializable{

	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "FILE_NAME")
	private String fileName;

	@Column(name = "LOCATOIN")
	private String location;

	@Column(name = "FILE_TYPE")
	private String fileType;

	@Lob
	@Column(name = "FILE_CONTENT")
	private String content;

	@Column(name = "CREATION_DATE")
	private Date creationDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "DocumentDto [id=" + id + ", fileName=" + fileName
				+ ", location=" + location + ", fileType=" + fileType
				+ ", content=" + content + ", creationDate=" + creationDate
				+ "]";
	}

}
