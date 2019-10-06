package com.xja.gmsc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xja.gmsc.domain.Goods;
import com.xja.gmsc.domain.GoodsImg;
import com.xja.gmsc.service.ISearchSingleElectricalInfoService;
import com.xja.gmsc.service.impl.SearchSingleElectricalInfoServiceImpl;

/**
 * 根据某个商品的id查询商品的信息
 * @author Administrator
 *
 */
@WebServlet("/SearchSingleElectricalInfoServlet")
public class SearchSingleElectricalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到电器商品的id
		Integer ElectricalId =new Integer(request.getParameter("ElectricalId"));
		//根据传入的商品id查询该件商品的详细信息
		ISearchSingleElectricalInfoService singleElectricalInfo = new SearchSingleElectricalInfoServiceImpl();
		Goods goods = singleElectricalInfo.searchSingleGoodInfo(ElectricalId);
		//根据商品信息中的商品goods_img(大图id)查找其对应的中图图片地址
		GoodsImg findModdlePictureAndPath= singleElectricalInfo.findModdlePictureAndPathByGoodId(goods.getGoodsId());
		//查询该件商品中图所对应的小图
		List<GoodsImg> listGoodsImg = singleElectricalInfo.findAllSmallPictureWithMiddleByGoodId(goods.getGoodsId());
		//把该件商品信息放入request域中
		request.setAttribute("singlegoods", goods);
		//把改件商品的中图路径放入request域中
		request.setAttribute("goodimg", findModdlePictureAndPath);
		//把所有中图所对应的小图放入request域中
		request.setAttribute("allsmallimgs", listGoodsImg);
		//请求转发给info.jsp页面
		request.getRequestDispatcher("info.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
