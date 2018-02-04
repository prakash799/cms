/**
Copyright Prakash
All rights reserved
 */
package com.cms.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component("filereader")
public class FileReader {

	//private static final String FILE_PATH="E:\\uploadedfiles";
	
	
	public String readFile(CommonsMultipartFile aFile) throws IOException {
		
		/*File file = new File(FILE_PATH, aFile.getName());
		
		BufferedInputStream inputStream=null;
		FileOutputStream outputStream=null;
		
		
		
		inputStream = new BufferedInputStream(new ByteArrayInputStream(aFile.getBytes()));
		
		byte[]buffer=new byte[8192];
		int bytesRead;
		while ((bytesRead = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, bytesRead);
		}*/
		
		
		ByteArrayInputStream stream = new ByteArrayInputStream(aFile.getBytes());
		String data = IOUtils.toString(stream, "UTF-8");
		return data;
	}
	

}
