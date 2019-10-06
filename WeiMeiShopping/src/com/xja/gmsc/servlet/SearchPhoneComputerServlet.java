package com.xja.gmsc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xja.gmsc.domain.Goods;
import com.xja.gmsc.service.ISearchPhoneComputerService;
import com.xja.gmsc.service.impl.SearchPhoneComputerSreviceImpl;

/**
 * 查询所有的电脑产品
 * @author Administrator
 *
 */
@WebServlet("/SearchPhoneComputerServlet")
public class SearchPhoneComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in SearchPhoneComputerServlet");
		//查询所有的电脑
		ISearchPhoneComputerService searchPhoneComputerService = new SearchPhoneComputerSreviceImpl();
		List<Goods> computerProductslists = searchPhoneComputerService.findAllComputerProducts();
		//System.out.println("computerLists="+computerProductslists);
		request.getSession().setAttribute("computerLists", computerProductslists);
		//request.setAttribute("computerLists", computerProductslists);		
		request.getRequestDispatcher("/catlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
