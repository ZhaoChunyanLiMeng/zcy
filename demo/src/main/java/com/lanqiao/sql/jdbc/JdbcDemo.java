package com.lanqiao.sql.jdbc;
/**
 * 简单JDBC演示
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
	public static void main(String[] args){
		Connection conn=null;
		
		try {
			//1、加载驱动
			
			Class.forName("com.mysql.jdbc.Driver");
			//2、url、username、password
			
			String url = "jdbc:mysql://localhost:3306/test";//thin:连接方式；@localhost:本机端口；1521:端口号；登录方式orcl
			String username = "root";
			String pwd = "root";
			 
			//3、conn
			conn=DriverManager.getConnection(url, username, pwd);
			//4、statement
			Statement stmt=conn.createStatement();
			//5、执行sql,如果是查询会得到一个结果集
			String sql="";
			ResultSet rs = stmt.executeQuery(sql);
			//元数据
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount();
			for(int i=1;i<=columnCount;i++){
				System.out.println(md.getColumnName(i)+"\t"+md.getColumnTypeName(i));//获取列的名称及列的数据类型
			}
			System.out.println("----------");
			//处理结果集result
			while(rs.next()){
				System.out.println(rs.getString("id")+"\t"+rs.getString("username"));
                System.out.println(rs.getString(1)+"\t"+rs.getString(2));
                System.out.println("----------------------------------");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(conn!=null){
				conn.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
