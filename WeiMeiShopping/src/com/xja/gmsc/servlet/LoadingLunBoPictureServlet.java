package com.xja.gmsc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xja.gmsc.domain.LoadPicture;
import com.xja.gmsc.service.ILoadingLunBoPictureService;
import com.xja.gmsc.service.impl.LoadingLunBoPictureServiceImpl;

/**
  * 加载轮播图
 * @author Administrator
 *
 */
@WebServlet("/LoadingLunBoPictureServlet")
public class LoadingLunBoPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ILoadingLunBoPictureService loadLunBoPicture = new LoadingLunBoPictureServiceImpl();
		List<LoadPicture> listLoadLunBo = loadLunBoPicture.findAllLunBoPicture();
		request.setAttribute("LunBoPictures", listLoadLunBo);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
