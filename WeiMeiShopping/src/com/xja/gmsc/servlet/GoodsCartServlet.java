package com.xja.gmsc.servlet;

import java.io.IOException;
import java.util.HashMap;
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
  * 购物车信息
 * @author Administrator
 *
 */
@WebServlet("/GoodsCartServlet")
public class GoodsCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in GoodsCartServlet");
		Integer goodsId = new Integer(request.getParameter("goodsId"));
		//根据当前加入购物车的商品id得到当前商品的详细信息
		ISearchSingleElectricalInfoService singleElectricalInfo = new SearchSingleElectricalInfoServiceImpl();
		//此时的商品Goods要重写equals和hashCode
		Goods goods = singleElectricalInfo.searchSingleGoodInfo(goodsId);
		//使用map来存储当前购物车信息，
		//购买当前商品作为key,购买的数量作为value值，为Integer类型
		//Map<Goods,Integer> cartMap = new HashMap<Goods,Integer>();
		//先重sesseion域中获取购物车是否存在
		@SuppressWarnings("unchecked")
		Map<Goods,Integer> cartMap = (Map<Goods, Integer>) request.getSession().getAttribute("goodsCart");
		//System.out.println("carMap="+cartMap);
		//判断当前购物车是否为空
		if(cartMap==null) {
			//如果为空则创建该购物车
			cartMap = new HashMap<Goods,Integer>();
		}
		/*
		        根据map集合的特点，当键（key即goods)重复时，put方法返回值为原来的(上一次放入的)value,在此反回的是Integer
		        由此判断，当根据id查找购物车中的商品时，如果未查找到，此时goods=null,
	     */
		//如果goods=null,则此时的count=null,原来没有商品，则此时商品数量为1,直接将商品放入购物车
		//把该件商品的放入购物车并数量为1
		Integer count = cartMap.put(goods, 1);//如果此件商品第一次进入购物车，则返回null;
		if(count != null) {//不为空，即原来购物车中存在此种(相同的)商品,即数量+1
			cartMap.put(goods, count+1);
		}
		//将购物车放入session域
		request.getSession().setAttribute("goodsCart",cartMap);
		//请求转发
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
