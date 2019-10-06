package com.xja.gmsc.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.group.interceptors.TwoPhaseCommitInterceptor.MapEntry;

import com.xja.gmsc.domain.Goods;
import com.xja.gmsc.service.ISearchSingleElectricalInfoService;
import com.xja.gmsc.service.impl.SearchSingleElectricalInfoServiceImpl;

/**
 * 删除购物车中的商品
 * @author Administrator
 *
 */
@WebServlet("/RemoveGoodsCartServlet")
public class RemoveGoodsCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in RemoveGoodsCartServlet");
		Integer goodsid =new Integer(request.getParameter("goodsid"));
		//根据当前加入购物车的商品id得到当前商品的详细信息
		ISearchSingleElectricalInfoService singleElectricalInfo = new SearchSingleElectricalInfoServiceImpl();
		//此时的商品Goods要重写equals和hashCode
		Goods goods = singleElectricalInfo.searchSingleGoodInfo(goodsid);
		Map<Goods,Integer> carMap = (Map<Goods, Integer>) request.getSession().getAttribute("goodsCart");
        carMap.remove(goods);//数量为零，清空商品信息
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
