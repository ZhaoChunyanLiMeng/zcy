package com.lanqiao.sql.jdbc.utils;

import java.sql.ResultSet;

/**
 * 先写一个JDBC接口
 * @author 燕
 *
 */
public interface JDBCFacade {
	/**
	 * 功能：查询
	 * @param sql
	 * @return ResultSet 
	 */
	ResultSet executeQuery(String sql);
	/**
	 * 功能：更改
	 * @param sql
	 * @return int 返回修改影响的行数
	 */
	int executeUpdate(String  sql);
}
