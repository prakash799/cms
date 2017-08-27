/**
Copyright Prakash
All rights reserved
 */
package com.cms.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component("filereader")
public class FileReader {

	public String readFile(CommonsMultipartFile aFile) throws IOException {
		ByteArrayInputStream stream = new ByteArrayInputStream(aFile.getBytes());
		String data = IOUtils.toString(stream, "UTF-8");
		return data;
	}
	

}
