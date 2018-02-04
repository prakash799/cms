/**
Copyright Prakash
All rights reserved
*/
package com.cms.security;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cms.img_video.DocumentDto;

@Component("fileValidator")
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return DocumentDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DocumentDto doc=(DocumentDto) target;
		String fileName = doc.getFileName();
		
		
		if(fileName.isEmpty()||fileName.equals("")) {
			errors.rejectValue("fileName", "error.fileName","Please Select a File");
		}
	}

}
