package com.mybatis.servlet;

import java.io.IOException;
import java.io.Reader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.Tuser;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public UserServlet() {
		// TODO Auto-generated constructor stub
	}

	private SqlSessionFactory ssf;
	private SqlSession ss;
	private UserMapper um;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		try {
			Reader reader = org.apache.ibatis.io.Resources.getResourceAsReader("mybatis.xml");
			ssf = new SqlSessionFactoryBuilder().build(reader);
			ss = ssf.openSession();
			um = ss.getMapper(UserMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Tuser t = new Tuser();
		Tuser user = um.listall(name);
		if (user != null) {
			
		} 
		
		ss.commit();
		ss.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
