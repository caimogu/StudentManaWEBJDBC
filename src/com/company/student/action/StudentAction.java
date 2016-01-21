package com.company.student.action;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.company.student.bean.Student;
import com.company.student.service.StudentService;

public class StudentAction extends GenericServlet{
	/*
	 * ��һ�����Ҫ���ܾ�����תҳ��ͷ�������
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StudentService studentService;
	public StudentAction()
	{
		studentService = new StudentService();
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("StudentAction--service()---");
		//�����ݿ��в������� ��������ʱ���������޸�
		request.setCharacterEncoding("UTF-8");
		
		String a = request.getParameter("a");
		if(a == null){
			list(request,response);
			return;
		}
		if(a.equals("save")){
			save(request,response);
			//return;
		}else if(a.equals("del")){
			delete(request,response);
			
		}else if(a.equals("modify")){
			modify(request,response);
			
		}else if(a.equals("savemodify")){
			update(request,response);
			
		}
		
		
	}
	

	private void update(ServletRequest request, ServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = studentService.findOne(id);
		student.setName(request.getParameter("name"));
		student.setScore(Float.parseFloat(request.getParameter("score")));
		
		studentService.update(student);
		
		HttpServletResponse res = (HttpServletResponse)response;
		res.sendRedirect("student.do");
	}

	private void modify(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("student", studentService.findOne(id));
		request.getRequestDispatcher("jsp/modify.jsp").forward(request, response);
	}

	private void delete(ServletRequest request, ServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		studentService.delete(id);
		HttpServletResponse res = (HttpServletResponse)response;
		res.sendRedirect("student.do");
	}

	private void list(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("StudnetService--list()---");
		
		req.setAttribute("studentList", studentService.findAll());
		req.getRequestDispatcher("jsp/list.jsp").forward(req, resp);
	}


	private void save(ServletRequest req, ServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("StudentService-save()---");
		
		Student student = new Student();
		student.setId(Integer.parseInt(req.getParameter("id")));
		student.setName(req.getParameter("name"));
		student.setScore(Float.parseFloat(req.getParameter("score")));
		
		studentService.add(student);
		//�����ýű�����ת location�ǵ�ַ��   ע���д����ĸ��������
		resp.getWriter().println("<script>location.href='index.jsp'</script>");;
		
	}

}
