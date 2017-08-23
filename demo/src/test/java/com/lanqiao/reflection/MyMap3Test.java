package com.lanqiao.reflection;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MyMap3Test {

	@Test
	public void test() throws Exception {
		
			Map mymap = new HashMap();
			mymap.put("name","wrg");
			mymap.put("age", 10);
			
			MyMap3 my=new MyMap3() ;
		    Student2 stu =my.map2Bean(mymap,Student2.class );
			
			System.out.println("姓名为："+stu.getName()+"            "+"年龄为："+stu.getAge());


	}

}
