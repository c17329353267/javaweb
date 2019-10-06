package com.xja.gmsc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xja.gmsc.domain.Register;

/**
 * 登陆过滤器，未登陆不能进行访问其他资源以及购买商品查看购物车
 * @author Administrator
 *
 */
public class LoginFilter implements Filter {

	//确定不经过过滤器的页面url
	//LoaddingLunBoPictureServlet.java
	String[] pass_url = {"/UserRegisterServlet","/UserLoginServlet","/LoadingLunBoPictureServlet","/index.jsp","/header.jsp","/register.jsp"};
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		//获取请求中的uri
		String requestUri = request.getRequestURI();
		boolean flag = false;
		//判断请求中的uri是否是被放行的目标LoadingLunBoPictureServlet
		for(String str:pass_url) {
			if(requestUri.contains(str)) {
				//放行
				flag = true;
				filterChain.doFilter(request, response);
				return;
			}
		}
		
		//拦截的其他路径
		if(!flag) {
			//判断session域中是否存在用户
			Register register = (Register) request.getSession().getAttribute("register");
			if(register != null) {
				//判断存在用户已经登陆
				filterChain.doFilter(request, response);
			}else {
				//跳转到登陆界面登陆
				request.setAttribute("error", "请登录后进行购物");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
	}



}
