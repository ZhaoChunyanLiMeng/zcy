package com.lanqiao.reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *  任务二   ! ! ! 根据值的类型来确定对应的是哪个
 * 将制定的map转换为指定的claz代表的类型的一个实例（下称bean）
 * bean即为student   map中key放student的属性；map中的value 放student的 属性值
 * @author 燕
 */
public class MyMap3 {
	
	public static <T> T map2Bean(Map<String,String> map,Class<T> claz) throws Exception{
	
		 //一个Map用来映射student
		T o=claz.newInstance();
		
		Field[] field=claz.getFields();//获取student 的属性 name 和 age
	
		for (Field fs : field) { 
			//   判断传入类的属性       把map 的键赋给 属性；把map的值给student 的属性的值
		for (Object s : map.keySet()) {
			fs.setAccessible(true);
				if(((fs.getName())).equals(s.toString())){         //如果指定类的属性的名字 与 map的键的名字 相同
					 fs.set(o, map.get(s));
				}else if((fs.getName()).equals(s.toString())){
					fs.set(o, map.get(s));
						
					 }  else{ 
						System.out.println("未找到对应类型");
						 }
			}
			return o ;
		}
	
	return o;
	}
}
