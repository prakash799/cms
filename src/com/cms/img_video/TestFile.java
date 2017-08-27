/**
Copyright Prakash
All rights reserved
*/
package com.cms.img_video;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class TestFile {

	public static void main(String[] args) {
		
		File file = new File("E:\\Docs and Notes\\GettingStartedWithProjects.txt");
		String path = file.getAbsolutePath();
		System.out.println(path);
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"Cp1252"));
			String line;
			try {
				while((line=bufferedReader.readLine())!=null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.out.println("unable to read file");
			e.printStackTrace();
		}
		
	}
}
