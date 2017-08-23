package com.lanqiao.sql.jdbc.utils;

import java.sql.SQLException;

/**
 * 功能：把数据库访问包中的异常统一作为运行时异常处理
 * @author 燕
 *
 */
public class DbAcessException extends RuntimeException {
	public DbAcessException(SQLException e){
		super(e);
	}
}
