package com.lanqiao.reflection;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lanqiao.sql.jdbc.utils.DbConst;

public class ReflectListTest {

	@Test
	public void testRs2List() throws Exception{
		Connection conn=null;
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());//加载驱动
		conn=DriverManager.getConnection(DbConst.url, DbConst.user, DbConst.pwd);//获得连接
		Statement stmt = conn.createStatement();//连接的一个对象
		String sql="select stuName from student where stuno=001";
		ResultSet rs=stmt.executeQuery(sql);//接收查询语句
	    
		
		ReflectList rl=new ReflectList();
		List<student>list=rl.rs2List(rs, student.class);
		System.out.println(list);
	}

}
