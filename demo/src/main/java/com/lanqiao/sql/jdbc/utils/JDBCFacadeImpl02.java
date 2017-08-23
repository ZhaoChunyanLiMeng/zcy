package com.lanqiao.sql.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.sun.istack.internal.logging.Logger;
import com.sun.rowset.CachedRowSetImpl;

public enum JDBCFacadeImpl02 implements JDBCFacade {
	me; //定义一个枚举变量代表 一个实例
	/**
	 * 抛出异常时进入日志， 建日志Logger
	 */
	static final Logger LOGGER=Logger.getLogger(JDBCFacadeImpl02.class);
	/**
	 * 在生成这个类实例时，即调用构造函数时，向连接池里放连接，以免产生空指针异常（获取不了Statement）
	 */
	private JDBCFacadeImpl02(){
		init();
	}
	/**
	 * 建一个连接池，用来存放连接
	 * LinkedBlockingQueue<Connection>(max)---有一个最大值，可以用来存放有限个数的连接
	 */
	final BlockingQueue<Connection> connQueue=new LinkedBlockingQueue<Connection>(10);
	
	@Override
	public ResultSet executeQuery(String sql) {
		try {
			Connection conn=null;
			conn=getconn();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			return cacheRS(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}//获取连接对象
		
		return null;
	}

	@Override
	public int executeUpdate(String sql) {
		return 0;
	}

/**
 * createconn()方法抽取出来，用来生产Connection（放在连接池里）
 * @return
 */
	private Connection createconn()throws SQLException {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection conn=DriverManager.getConnection(DbConst.url, DbConst.user, DbConst.pwd);//获得连接
			return conn;
	}
	/**
	 * init()方法用来 初始化 连接池，把生产的conn放在连接池中
	 */
	private void init(){
		for(int i=0;i<10;i++){
			try {
				connQueue.add(createconn());
			} catch (SQLException e) {
				throw new DbAcessException(e);//作为运行时异常处理
			}
		}
	}
/**
* getconn()方法抽取出来，用来获取连接
* @return Connection
*/
		private Connection getconn() {
			return connQueue.poll();//从连接池里取一个连接返回用于上面获取连接。
		}
/**
 * cacheRS(ResultSet rs)方法，通过这个方法来缓存 rs,
 * 很多情况我们使用ResultSet 就会因为这样那样的问题，rs被关闭或数据链接被关闭，导致ResultSet不能使用。
 * 这个问题我们可以用CachedRowSetImpl来解决。这是一个结果的缓存类，保存在其中的数据不会随着数据库和ResultSet的连接的关闭而丢失，可以传递
 * @param rs
 * @return  ResultSet---结果集
 * 数据库和ResultSet的连接都已经关闭了，而且仍然可以进行数据循环出值来
 */
		private ResultSet cacheRS(ResultSet rs)throws SQLException{
			CachedRowSetImpl rowset=new CachedRowSetImpl();//创建一个rowse用来缓存结果
			rowset.populate(rs);//把rs放进去
			return rowset;
		}



}
