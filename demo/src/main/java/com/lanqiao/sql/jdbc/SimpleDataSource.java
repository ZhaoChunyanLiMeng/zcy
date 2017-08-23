package com.lanqiao.sql.jdbc;

import java.sql.Connection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 功能：简易连接池实现
 * @author 燕
 *
 */
public enum SimpleDataSource {
	me;
	//阻塞队列，应对多线程请求连接
	private BlockingQueue<Connection> pool = new LinkedBlockingQueue<Connection>();
	
	private SimpleDataSource(){
		//Class.forName())
	}
}
