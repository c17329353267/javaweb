package com.xja.gmsc.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xja.gmsc.domain.Goods;
import com.xja.gmsc.service.ISearchSingleElectricalInfoService;
import com.xja.gmsc.service.impl.SearchSingleElectricalInfoServiceImpl;
/**
  * 购物车的改变
 * @author Administrator
 *
 */
@WebServlet("/GoodsChangCartServlet")
public class GoodsChangCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//根据id查找购物车中的商品
		Integer goodsId = new Integer(request.getParameter("goodsid"));
		Integer buyNum = new Integer(request.getParameter("buynum"));
		//根据当前加入购物车的商品id得到当前商品的详细信息
		ISearchSingleElectricalInfoService singleElectricalInfo = new SearchSingleElectricalInfoServiceImpl();
		//此时的商品Goods要重写equals和hashCode
		Goods goods = singleElectricalInfo.searchSingleGoodInfo(goodsId);
		 Map<Goods,Integer> carMap = (Map<Goods, Integer>) request.getSession().getAttribute("goodsCart");
        if(buyNum == 0){
            carMap.remove(goods);//数量为零，清空商品
        }else{
            carMap.put(goods,buyNum);
        }
        request.getRequestDispatcher("buy.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
