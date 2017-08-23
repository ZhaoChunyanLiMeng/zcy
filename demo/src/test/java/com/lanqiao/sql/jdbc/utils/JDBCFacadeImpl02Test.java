package com.lanqiao.sql.jdbc.utils;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class JDBCFacadeImpl02Test {
/**
 * 测试executeQuery（）方法
 * @throws SQLException
 */
	@Test
	public void test() throws SQLException{
		String sl="select stuName from student where stuno=001";
		ResultSet rs=JDBCFacadeImpl02.me.executeQuery(sl);
		assert(rs.next());
	}

}
