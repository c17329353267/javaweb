package com.xja.gmsc.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Data;
import com.xja.gmsc.domain.Goods;
import com.xja.gmsc.domain.GoodsOrder;
import com.xja.gmsc.domain.GoodsPayMoney;
import com.xja.gmsc.domain.Register;
import com.xja.gmsc.service.IGoodsCreateOrderService;
import com.xja.gmsc.service.impl.GoodsCreateOrderServiceImpl;

/**
  * 创建订单的servlet
 * @author Administrator
 *
 */
@WebServlet("/GoodsCreateOrderServlet")
public class GoodsCreateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in GoodsOrderServlet");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取收件人姓名
		String receiveName = request.getParameter("username");
		//获取收件人地址
		String receiveAddress = request.getParameter("address");
		//获取收件人电话
		String receivePhone = request.getParameter("tel");
		//获取登陆人信息
		Register register = (Register) request.getSession().getAttribute("register");
		String loginUsernameInfo = register.getLoginName();
		//封装订单信息
		GoodsOrder goodsOrder = new GoodsOrder();
		goodsOrder.setReceiveName(receiveName);
		goodsOrder.setReveivePhone(receivePhone);
		goodsOrder.setReceiveAddress(receiveAddress);
		goodsOrder.setLoginName(loginUsernameInfo);
		//从session域中获取购物车信息
		Map<Goods,Integer> cartMap = (Map<Goods, Integer>) request.getSession().getAttribute("goodsCart");
		//创建订单信息
		IGoodsCreateOrderService goodsCreateOrderService = new GoodsCreateOrderServiceImpl();
		//得到创建新的订单id集合
		List<Integer> GoodsNewOrderIds = goodsCreateOrderService.createGoodsOrder(cartMap,goodsOrder);
		//根据自己购买的所有订单id，进行支付
		String goodsTotalMoney = goodsCreateOrderService.getTotalMoneyByGoodsNewOrderIds(loginUsernameInfo);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String goodsPayTime = sdf.format(date); 
		//创建购物付钱实体类
		GoodsPayMoney goodsPayMoney = new GoodsPayMoney();
		goodsPayMoney.setGoodsPayId(UUID.randomUUID().toString());
		goodsPayMoney.setGoodsOrderName(UUID.randomUUID().toString());
		goodsPayMoney.setGoodsTotalMoney(goodsTotalMoney);
		goodsPayMoney.setGoodsPayTime(goodsPayTime);
		goodsPayMoney.setGoodsPayUsername(receiveName);
		goodsPayMoney.setGoodsReceiveAddr(receiveAddress);
		goodsPayMoney.setGoodsreceivePhone(receivePhone);
		System.out.println("goodsNewOrderIds="+GoodsNewOrderIds);
		//移除session域中购物车
		request.getSession().removeAttribute("goodsCart");
		//将订单放入到session域中
		request.getSession().setAttribute("goodsOrder", goodsOrder);
		//将产生新的订单di集合放入session域中
		request.getSession().setAttribute("GoodsNewOrderIds", GoodsNewOrderIds);
		//将购物支付实体类放入session域中
		request.getSession().setAttribute("goodsPayMoney", goodsPayMoney);
		//跳转支付界面
		request.getRequestDispatcher("/AliPayOrderServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
