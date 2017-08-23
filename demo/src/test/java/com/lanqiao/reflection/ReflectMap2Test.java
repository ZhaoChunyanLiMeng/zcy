package com.lanqiao.reflection;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ReflectMap2Test {

	@Test
	public void testMap2Bean() throws Exception {
		Map<String, String> mymap = new HashMap();
		mymap.put("name", "zhangsan");
		mymap.put("age","10");
		
		ReflectMap2 reflectionm=new ReflectMap2();
		Student2 stu = reflectionm.map2Bean(mymap, Student2.class);
		System.out.println("年龄为："+stu.getName()+"年龄为："+stu.getAge());
	}

}
