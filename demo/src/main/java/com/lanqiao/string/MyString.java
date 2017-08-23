package com.lanqiao.string;

import org.apache.commons.lang3.StringUtils;

public class MyString {

	public static void main(String[] args) {
		StringUtils s= new StringUtils();
	    String a=new String();
	    a="abc";
	   System.out.println( s.strip(a, "c"));
	}

}
