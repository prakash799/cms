/**
Copyright Prakash
All rights reserved
*/
package com.cms.img_video;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.hibernate.type.descriptor.java.UUIDTypeDescriptor.ToBytesTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cms.security.FileValidator;
import com.cms.util.FileReader;
import com.sun.mail.iap.ByteArray;

@Controller
public class DocumentController {

	private static final String FILE_PATH="E:\\uploadedfiles";
	
	@Autowired
	@Qualifier("documentDao")
	DocumentDao documentDao;
	
	@Autowired
	@Qualifier("filereader")
	FileReader fileReader;
	
	@Autowired
	@Qualifier("fileValidator")
	FileValidator 	fileValidator;
	
	public void setFileValidator(FileValidator fileValidator) {
		this.fileValidator = fileValidator;
	}

	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}

	@RequestMapping(value= {"uploadnewfile"},method= {RequestMethod.GET,RequestMethod.POST})
	public String openUploadPage(@ModelAttribute("dataUpload")DocumentDto docDto,Model model) {
		return "upload";
	}
	
	
	@RequestMapping(value= {"uploadFile"},method= {RequestMethod.POST})
	public String doUpload(HttpServletRequest request,@RequestParam CommonsMultipartFile multipartFile,RedirectAttributes redirectAttributes) {
		
		//BufferedWriter bufferedWriter = null;
		FileOutputStream outputStream=null;
		
		if(multipartFile.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please Select a File");
			return "redirect:/uploadnewfile";
		}else {
			System.out.println("Saving file in database"+multipartFile.getOriginalFilename());
			FileItem fileItem = multipartFile.getFileItem();
			try {
				
				String fileType = fileItem.getContentType();
				String name = fileItem.getName();
				long size = fileItem.getSize();
				
				DocumentDto documentDto = new DocumentDto();
				
				documentDto.setFileName(name);
				documentDto.setFileType(fileType);
				documentDto.setFileSize(size);
				
				File file = new File(FILE_PATH);
				long lastModified = file.lastModified();
				String path = file.getAbsolutePath();
				File actualFilePath = new File(FILE_PATH, fileItem.getName());
				
				System.out.println(new FileReader().readFile(multipartFile));
				
				String filecontent = this.fileReader.readFile(multipartFile);
				
				outputStream = new FileOutputStream(actualFilePath);
				outputStream.write(filecontent.getBytes());
				
				
				
				//bufferedWriter = new BufferedWriter(new FileWriter(actualFilePath));
				//bufferedWriter.write(filecontent);
				
				java.sql.Date date = new java.sql.Date(lastModified);
				documentDto.setCreationDate(date);
				documentDto.setLocation(path+File.separator+name);
				this.documentDao.insert(documentDto);
				redirectAttributes.addFlashAttribute("message", "File uploaded successfully"+fileItem.getName());
			}catch(IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
				return "redirect:/uploadnewfile";
			}
		}
	}