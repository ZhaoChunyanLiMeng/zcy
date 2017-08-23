package com.lanqiao.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 任务一
 *功能:使用反射基本打印一个类的基本信息
 * @author 燕
 *
 */
public class MyReflection {

	public static void main(String[] args) {
		
		try {
			Class claz=Class.forName("java.lang.String");
			Object o=claz.newInstance();
			System.out.println("--------------------此下为属性---------------------------");
		/**
		 * 动态操作属性
		 */
			Field[] field=claz.getDeclaredFields();
			for (Field fs : field) {
				fs.setAccessible(true);
				System.out.println(fs.toString());
			}
			System.out.println("----------------------此下为构造方法---------------------");
			/**
			 * 动态操作构造方法
			 */
			Constructor[]  consructer=claz.getDeclaredConstructors();
			for (Constructor cs : consructer) {
				System.out.println(cs.toString());
			}
			System.out.println("--------------------------此下为方法----------------------------");
			/**
			 * 动态操作方法
			 */
			Method[] methods=claz.getMethods();
			for (Method ms : methods) {
				System.out.println(ms.toString());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}

}
