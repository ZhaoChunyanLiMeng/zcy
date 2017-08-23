package com.lanqiao.reflection;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ReflectMapTest {

	@Test
	public void testMap2Bean() throws Exception{
		Map mymap = new HashMap();
		mymap.put("name","wrg");
		mymap.put("age","10");
		
		ReflectMap my=new ReflectMap ();
		Student2 stu=my.map2Bean(mymap, Student2.class);
		
		assertTrue(stu.getAge()==10);
	}

}
