package com.lanqiao.sql.jdbc.utils;
/**
 * 功能：测试JDBCFacadeImpl
 */
import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class JDBCFacadeImplTest {
/**
 * 功能：测试executeQuery()方法
 */
	@Test
	public void test() {
		String s="select stuName from student where stuno=001";
		ResultSet rs=new JDBCFacadeImpl().executeQuery(s);
		try {
			assertTrue(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testUpdate(){
		String s="update student set stuName='zcy' where stuno=001";
		int rowcount=new JDBCFacadeImpl().executeUpdate(s);
		System.out.println(rowcount);
	}
	

}
