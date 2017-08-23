package com.lanqiao.sql.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJDBC {
	/**
	 * 功能：通过数据库提取表的数据
	 * @param sql
	 * @return
	 */
	public ResultSet Query(String sql) {
		Connection conn=null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());//加载驱动
			conn=DriverManager.getConnection(DbConst.url, DbConst.user, DbConst.pwd);//获得连接
			Statement stmt = conn.createStatement();//连接的一个对象
			ResultSet rs=stmt.executeQuery(sql);//接收查询语句
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 功能：通过数据库更新表的数据
	 * @param sql
	 * @return
	 */
	public int Update(String sql) {
		Connection conn=null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn=DriverManager.getConnection(DbConst.url, DbConst.user, DbConst.pwd);//获得连接
			Statement stmt = conn.createStatement();//连接的一个对象
			int rowcount=stmt.executeUpdate(sql);//影响的行数
			return rowcount;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
