/**
Copyright Prakash
All rights reserved
*/
package com.cms.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;
@Component("encryptpassword")
public class EncryptPassword {

	public String generateHashCode(String hashString) throws NoSuchAlgorithmException {
		String algoName="MD5";
		String hashCode="";
		if(hashString==null)throw new NullPointerException("hash String cannot be null");
		StringBuffer buffer = new StringBuffer();
		MessageDigest messageDigest = MessageDigest.getInstance(algoName);
		byte[] data = hashString.getBytes();
		messageDigest.update(data);
		byte[] digest = messageDigest.digest();
		for(int i=0;i<digest.length;i++) {
			buffer=buffer.append(digest[i]);
		}
		hashCode = buffer.toString();
		System.out.println("hashed password: "+hashCode);
		return hashCode;
			
	}
}
