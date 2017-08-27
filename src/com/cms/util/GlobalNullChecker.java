/**
Copyright Prakash
All rights reserved
 */
package com.cms.util;

public class GlobalNullChecker {
	
	public static boolean empty( final String s ) {
		  // Null-safe, short-circuit evaluation.
		  return s == null || s.trim().isEmpty();
		}
	
	
	//for Object type null checking
	public static boolean isNullObject(Object o) {
		return o==null;
	}
}
