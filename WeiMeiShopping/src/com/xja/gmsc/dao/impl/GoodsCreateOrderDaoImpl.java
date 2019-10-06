package com.xja.gmsc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.xja.gmsc.dao.BaseDao;
import com.xja.gmsc.dao.GoodsCreateOrderDao;
import com.xja.gmsc.domain.GoodsDetails;
import com.xja.gmsc.domain.GoodsOrder;

public class GoodsCreateOrderDaoImpl extends BaseDao implements GoodsCreateOrderDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	//添加订单详情
	@Override
	public Integer insertGoodsOrderDetails(GoodsDetails goodsdetails) {
		Integer returnGoodsDetailsId = -1;
		try {
			conn = this.getConnection();
			String sql = "insert into tbl_gooddetails(goods_id,buynum,price,total,loginname,buystate,receivephone,receiveaddress,receivename)" 
					 +"VALUES(?,?,?,?,?,?,?,?,?)";
			String sql2 = "SELECT LAST_INSERT_ID() from tbl_gooddetails";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, goodsdetails.getGoodsId());
			pst.setString(2, goodsdetails.getBuyNum());
			pst.setString(3, goodsdetails.getSinglePrice());
			pst.setString(4, goodsdetails.getTotalPrice());
			pst.setString(5, goodsdetails.getLoginName());
			pst.setString(6, goodsdetails.getBuystate());
			pst.setString(7, goodsdetails.getReceivePhone());
			pst.setString(8, goodsdetails.getReceiveAddress());
			pst.setString(9, goodsdetails.getReceiveName());
			pst.executeUpdate();
			
			 pst = conn.prepareStatement(sql2);
			 rs = pst.executeQuery();
			 while(rs.next()) {
		
				 returnGoodsDetailsId = rs.getInt(1);
			 }
			//returnGoodsDetailsId = this.getGoodsDetailsId();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.release(conn, pst,rs);
		}
		return returnGoodsDetailsId;
	}
	
	@Override
	public Integer insertGoodsNewOrder(GoodsOrder goodsOrder,Integer returnGoodsDetailsId) {
		//初始化一个带有返回值的新的订单id
		Integer addOrderAfterId = null; 
		try {
			conn = this.getConnection();
			String sql = "INSERT into tbl_order(detailsId,orderstate,loginname) VALUES(?,?,?)";		
			String sql2 = "SELECT LAST_INSERT_ID() from tbl_order";
			pst = conn.prepareStatement(sql);
			pst.setString(1, returnGoodsDetailsId.toString());
			pst.setString(2, "订单已填写完毕等待付款！");
			pst.setString(3, goodsOrder.getLoginName());
			pst.executeUpdate();
			pst = conn.prepareStatement(sql2);
			 rs = pst.executeQuery();
			 while(rs.next()) {
				 addOrderAfterId = rs.getInt(1);
				 //System.out.println("addOrderAfterId="+addOrderAfterId);
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.release(conn, pst,rs);
		}
		return addOrderAfterId;
	}

	//根据订单id修改订单状态
	@Override
	public void updataOrderPayState(String out_trade_no) {
		// TODO Auto-generated method stub
		try {
			conn = this.getConnection();
			String sql = "update tbl_order set orderstate='已付款'  WHERE orderId = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, out_trade_no);
			pst.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.release(conn, pst);
		}
	}

	@Override
	public String getTotalMoneyByGoodsNewOrderIds(String goodsNewOrderIds) {
		String totalMoney = null;
		try {
			conn = this.getConnection();
			String sql = "select SUM(details.total) totalmoney from tbl_gooddetails details,tbl_order tord " + 
					"where tord.detailsId " + 
					"in (SELECT orderId from tbl_order where loginname = ?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, goodsNewOrderIds);
			rs = pst.executeQuery();
			while(rs.next()) {
				totalMoney = rs.getString("totalmoney");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.release(conn, pst, rs);
		}
		
		return totalMoney;
	}

}
