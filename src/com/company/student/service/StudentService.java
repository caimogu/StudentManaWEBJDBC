package com.company.student.service;

import java.sql.SQLException;
import java.util.List;

import com.company.student.bean.Student;
import com.company.student.dao.StudentDAO;

public class StudentService {
	/*
	 * service����Ҫ���� �����ݿ�֮���ͨ��
	 * 
	 * Ϊʲô��Ҫ����������ٵ���StudentDAO�еķ�����
	 * ��StudentDAO���׳����쳣����service��������
	 * 
	 */
	
	private StudentDAO studentDao;
	
	public StudentService()
	{
		System.out.println("StudentService-StudentService()---");
		studentDao = new StudentDAO();
	}
	
	public void add(Student student)
	{
		System.out.println("StudentService-add()---");
		try {
			studentDao.save(student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(Integer id)
	{
		try {
			studentDao.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Student> findAll()
	{
		System.out.println("StudentService-findAll()---");
		try {
			return studentDao.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public Student findOne(Integer id) {
		// TODO Auto-generated method stub
		try {
			return studentDao.getOneStudent(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void update(Student student) {
		// TODO Auto-generated method stub
		try {
			studentDao.update(student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
