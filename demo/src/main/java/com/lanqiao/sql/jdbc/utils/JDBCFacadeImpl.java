package com.lanqiao.sql.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;



public class JDBCFacadeImpl implements JDBCFacade {

	@Override
	public ResultSet executeQuery(String sql) {
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

	@Override
	public int executeUpdate(String sql) {
		Connection conn=null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn=DriverManager.getConnection(DbConst.url, DbConst.user, DbConst.pwd);//获得连接
			Statement stmt = conn.createStatement();//连接的一个对象
			int rowcount=stmt.executeUpdate(sql);//影响的行数
			return rowcount;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//加载驱动
		return 0;
	}

}
