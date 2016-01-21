package com.company.student.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.company.student.bean.Student;
import com.company.student.conn.MysqlConn;

public class StudentDAO {
	/*
	 * 对数据库的操作
	 */
	private MysqlConn mysql;
	private Connection conn; 
	private Statement st;
	
	
	public StudentDAO()
	{
		mysql = MysqlConn.getInstance();
		conn = mysql.getConn();
	}
	
	public void save(Student student) throws SQLException
	{
		System.out.println("StudentDAO-save()---");
		st = conn.createStatement();
		String sql = "INSERT INTO tb_student values("+student.getId()+",'"+student.getName()+"',"+student.getScore()+")";
		st.executeUpdate(sql);
		st.close();	
	}
	public void update(Student student) throws SQLException
	{
		System.out.println("StudentDAO-update()---");
		st = conn.createStatement();
		String sql = "update tb_student set name='"+student.getName()+"',score="+student.getScore()+" where id="+student.getId();
		System.out.println(sql);
		st.executeUpdate(sql);
		st.close();//注意结束后关闭语句
		
	}
	public void delete(Integer id) throws SQLException
	{
		System.out.println("StudentDAO-delete()---");
		st = conn.createStatement();
		String sql = "delete from tb_student where id="+id;
		System.out.println(sql);
		st.executeUpdate(sql);
		st.close();//注意结束后关闭语句
	}
	public List<Student> getAll() throws SQLException
	{
		System.out.println("StudentDAO-getAll()---");
		List<Student> list = new ArrayList<Student>();
		st = conn.createStatement();
		
		String sql = "select * from tb_student";
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next())
		{
			Student s = new Student();
			s.setId(rs.getInt("id"));
			s.setName(rs.getString("name"));
			s.setScore(rs.getFloat("score"));
			list.add(s);
		}
		rs.close();
		st.close();
		return list;
	}

	public Student getOneStudent(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		Student s = null;
		st = conn.createStatement();
		String sql = "select * from tb_student where id="+id;
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()){
			s = new Student();
			s.setId(rs.getInt("id"));
			s.setName(rs.getString("name"));
			s.setScore(rs.getFloat("score"));
			
		}
		st.close();
		return s;
	}
	
}
