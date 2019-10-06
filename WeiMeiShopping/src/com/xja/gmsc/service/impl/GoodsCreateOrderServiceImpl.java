package com.xja.gmsc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.xja.gmsc.dao.GoodsCreateOrderDao;
import com.xja.gmsc.dao.SearchPhoneComputerDao;
import com.xja.gmsc.dao.impl.GoodsCreateOrderDaoImpl;
import com.xja.gmsc.dao.impl.SearchPhoneComputerDaoImpl;
import com.xja.gmsc.domain.Goods;
import com.xja.gmsc.domain.GoodsDetails;
import com.xja.gmsc.domain.GoodsOrder;
import com.xja.gmsc.service.IGoodsCreateOrderService;

public class GoodsCreateOrderServiceImpl implements IGoodsCreateOrderService{

	GoodsCreateOrderDao goodsCreateOrderDao = new GoodsCreateOrderDaoImpl();
	SearchPhoneComputerDao computerDao = new SearchPhoneComputerDaoImpl();
	@Override
	public List<Integer> createGoodsOrder(Map<Goods, Integer> cartMap, GoodsOrder goodsOrder) {
		//定义一个新的订单id
		List<Integer> listsOrderIds = new ArrayList<Integer>();
		Integer newOrderId;
		//携带购物车信息 和订单信息
		//遍历购物车，将每一项商品购买的详细信息存入购物详情中
		for(Goods good:cartMap.keySet()) {
		//for(Entry<Goods, Integer> m:cartMap.entrySet()) {
			GoodsDetails goodsdetails = new GoodsDetails();//创建购物详情实体类
			//把商品放入订单项中
			goodsdetails.setGoodsId(good.getGoodsId());
			goodsdetails.setSinglePrice(good.getGoodsCurprice());
			//该件商品总价=现价*数量
			Double goodsTotalCurPrice = Double.parseDouble(good.getGoodsCurprice())*cartMap.get(good);
			goodsdetails.setTotalPrice(goodsTotalCurPrice.toString());//str
			goodsdetails.setReceiveAddress(goodsOrder.getReceiveAddress());
			goodsdetails.setBuyNum(cartMap.get(good).toString());
			goodsdetails.setReceiveName(goodsOrder.getReceiveName());
			goodsdetails.setReceivePhone(goodsOrder.getReveivePhone());
			goodsdetails.setLoginName(goodsOrder.getLoginName());
			//根据该商品id修改库存  两个参数分别是：商品id,商品购买数量
			computerDao.updateGoodsRepositoryNum(good.getGoodsId(),cartMap.get(good));
			//插入订单详情
			Integer returnGoodsDetailsId = goodsCreateOrderDao.insertGoodsOrderDetails(goodsdetails);
			//添加新的订单并返回新的订单id
			 newOrderId =  goodsCreateOrderDao.insertGoodsNewOrder(goodsOrder,returnGoodsDetailsId);
			 System.out.println("newOrderId");
			 listsOrderIds.add(newOrderId);//将每一天新的订单id封装到list集合中并作返回
		}
		return listsOrderIds;
	}
	//修改订单的状态
	@Override
	public void paySuccess(String out_trade_no) {
		//根据订单id修改订单状态  --》已付款
		goodsCreateOrderDao.updataOrderPayState(out_trade_no);
		//删除订单项
	}
	@Override
	public String getTotalMoneyByGoodsNewOrderIds(String loginname) {
		// TODO Auto-generated method stub
		return goodsCreateOrderDao.getTotalMoneyByGoodsNewOrderIds(loginname);
	}

}
