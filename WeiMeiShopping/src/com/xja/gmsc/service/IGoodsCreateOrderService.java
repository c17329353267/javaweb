package com.xja.gmsc.service;

import java.util.List;
import java.util.Map;

import com.xja.gmsc.domain.Goods;
import com.xja.gmsc.domain.GoodsOrder;

public interface IGoodsCreateOrderService {

	List<Integer> createGoodsOrder(Map<Goods, Integer> cartMap, GoodsOrder goodsOrder);

	void paySuccess(String out_trade_no);

	String getTotalMoneyByGoodsNewOrderIds(String goodsNewOrderIds);

}
