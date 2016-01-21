package com.company.student.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConn {
	/*
	 * 这一层主要是连接数据库操作
	 * 
	 * 注意这里的单列模式
	 */
	private static Connection conn;
	private static MysqlConn instance=null;
	public MysqlConn()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static MysqlConn getInstance()
	{
		if(instance==null)
		{
			instance = new MysqlConn();
		}
		return instance;
	}
	public  Connection getConn()
	{
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8","root","");
			System.out.println("数据库连接成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
