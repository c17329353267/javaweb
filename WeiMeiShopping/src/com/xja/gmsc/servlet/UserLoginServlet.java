package com.xja.gmsc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xja.gmsc.domain.Register;
import com.xja.gmsc.service.UserRegisterService;
import com.xja.gmsc.service.impl.UserRegisterServiceImpl;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in UserLoginServlet");
		//获取登陆的用户名和密码
		String loginname = request.getParameter("login");
		String loginpwd = request.getParameter("pwd");
		System.out.println(loginname+","+loginpwd);
		UserRegisterService userRegisterService = new UserRegisterServiceImpl();
		//根据用户名密码查询对应的用户
		Register register = userRegisterService.findRegisterByNameAndPwd(loginname,loginpwd);
		if(register != null) {
			//查询对应的用户
			request.getSession().setAttribute("register", register);
			request.getRequestDispatcher("login_success.jsp").forward(request, response);
		}else {
			request.setAttribute("error", "用户名或密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
