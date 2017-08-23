package com.lanqiao.practice;

import org.apache.commons.lang3.StringUtils;

/**2017-7-27 2
 * 功能：请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 思路：先把StringBuffer转换成String,然后转换为字符数组，检验空格，替换；最后把字符数组变回字符串
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author 燕
 *
 */
public class StringEmptyTo20 {
	public String replaceSpace(StringBuffer str) {
		 String sti = str.toString();
	        char[] strChar = sti.toCharArray();
	        StringBuffer stb = new StringBuffer();
	        for(int i=0;i<strChar.length;i++){
	            if(strChar[i]==' '){
	                stb.append("%20");
	            }else{
	                stb.append(strChar[i]);
	            }
	        }
	        return stb.toString();
			
	
    	
    }
}
