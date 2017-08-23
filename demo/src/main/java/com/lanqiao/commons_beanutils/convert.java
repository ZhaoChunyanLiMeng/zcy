package com.lanqiao.commons_beanutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

public class convert implements Converter {
		public Date convert(Class  type, Object value) {
		if(type!=Date.class){    //类型不是 日期类型
			return null;
		}
		if(value==null||"".equals(value.toString().trim())){   //值为空
			return null;
		}
		SimpleDateFormat dataFormat =new SimpleDateFormat("yyyy年MM月dd日");   //日期转换类
		Date data=null;  //新建一个空的日期变量，后边用来赋转换后日期
		try {
			data=dataFormat.parse((String)value); //把输入的值转换为日期格式
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return data;
		}
	
}
