package com.xja.gmsc.dao;

import java.util.List;

import com.xja.gmsc.domain.GoodsDetails;
import com.xja.gmsc.domain.GoodsOrder;

public interface GoodsCreateOrderDao {

	Integer insertGoodsOrderDetails(GoodsDetails goodsdetails);

	Integer insertGoodsNewOrder(GoodsOrder goodsOrder,Integer returnGoodsDetailsId);

	void updataOrderPayState(String out_trade_no);

	String getTotalMoneyByGoodsNewOrderIds(String goodsNewOrderIds);

}
