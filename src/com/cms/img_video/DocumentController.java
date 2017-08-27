/**
Copyright Prakash
All rights reserved
*/
package com.cms.img_video;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cms.util.FileReader;

@Controller
public class DocumentController {

	@Autowired
	@Qualifier("documentDao")
	DocumentDao documentDao;
	
	@Autowired
	@Qualifier("filereader")
	FileReader fileReader;
	
	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}

	@RequestMapping(value= {"uploadnewfile"},method= {RequestMethod.GET,RequestMethod.POST})
	public String openUploadPage(@ModelAttribute("dataUpload")DocumentDto docDto,Model model) {
		return "upload";
	}
	
	
	@RequestMapping(value= {"uploadFile"},method= {RequestMethod.POST})
	public String doUpload(HttpServletRequest request,@RequestParam CommonsMultipartFile fileName) {
		
		if(fileName!=null && (!fileName.isEmpty())) {
				System.out.println("Saving file in database"+fileName.getOriginalFilename());
				DocumentDto documentDto = new DocumentDto();
				documentDto.setFileName(fileName.getOriginalFilename());
				documentDto.setFileType(fileName.getContentType());
				try {
					System.out.println(new FileReader().readFile(fileName));
					documentDto.setContent(this.fileReader.readFile(fileName));
				} catch (IOException e) {
					System.out.println("File not found!");
					e.printStackTrace();
				}
				documentDto.setLocation(fileName.getStorageDescription());
				this.documentDao.insert(documentDto);
			
		}
		
		return "list_uploaded_data";
	}
}
