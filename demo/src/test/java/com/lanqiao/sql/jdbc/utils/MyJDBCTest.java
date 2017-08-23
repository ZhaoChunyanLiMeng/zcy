package com.lanqiao.sql.jdbc.utils;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class MyJDBCTest {
/**
 * 功能：测试 查询方法
 */
	@Test
	public void test() throws SQLException{
		String s="select stuName from student where stuno=001";
		MyJDBC mj=new MyJDBC();
		ResultSet rs=mj.Query(s);
		assert(rs.next());
	}

}
