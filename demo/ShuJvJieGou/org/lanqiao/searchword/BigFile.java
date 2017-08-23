package org.lanqiao.searchword;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class BigFile {
	/**
	 * 产生随机字符串,生成大文件
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) { //length表示生成字符串的长度
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   //
	        System.out.println(number);
	        sb.append(base.charAt(number));   //
	    }   
	    return sb.toString();   
	 }  
	public static void createFile() throws IOException{
		File file = new File("F:\\data\\test.txt");  
	    if (!file.exists()) {  
	           file.createNewFile();    //新的文件地址
		 }  
		 FileOutputStream fos = new FileOutputStream(file);  
		 OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8"); 
	     BufferedWriter out = new BufferedWriter(osw);  
		 String r =  getRandomString(20);  //产生随机字符串大文件
		 Long i=0L;
		 while(i<1000L){
			 i++;
			 out.write(r);
		 }
	}
	public static void main(String[] args) throws IOException{
		BigFile bigFile=new BigFile();
		bigFile.createFile();
	}
}
