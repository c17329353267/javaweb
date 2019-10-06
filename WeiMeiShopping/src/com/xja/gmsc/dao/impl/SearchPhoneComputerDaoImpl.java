package com.xja.gmsc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.xja.gmsc.dao.BaseDao;
import com.xja.gmsc.dao.SearchPhoneComputerDao;
import com.xja.gmsc.domain.Goods;

public class SearchPhoneComputerDaoImpl extends BaseDao implements SearchPhoneComputerDao {
	
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	@Override
	public List<Goods> selectAllComputers() {
		//查询所有的电脑
		List<Goods> listsGoods = new ArrayList<Goods>();
		try {
			conn = this.getConnection();
			String sql="select goods_id,goods_name,typeid,goods_price,goods_curprice,goods_repertory,goods_img,goods_state,goods_introduce," 
					 +"goods_linkman,imgpath from tbl_goods left JOIN tbl_imgs on imgid=goods_img";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Goods goods = new Goods();
				goods.setGoodsId(rs.getInt("goods_id"));
				goods.setGoodsCurprice(rs.getString("goods_curprice"));
				goods.setTypeId(rs.getString("typeid"));
				goods.setGoodsName(rs.getString("goods_name"));
				goods.setGoodsIntroduce(rs.getString("goods_introduce"));
				goods.setGoodsLinkman(rs.getString("goods_linkman"));
				goods.setGoodsPrice(rs.getString("goods_price"));
				goods.setGoodsRepertory(rs.getString("goods_repertory"));
				goods.setGoodsState(rs.getString("goods_state"));
				goods.setImgpath(rs.getString("imgpath"));
				goods.setGoodsImg(rs.getString("goods_img"));
				listsGoods.add(goods);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			this.release(conn, pst, rs);
		}
		return listsGoods;
	}
	//根据商品id和商品购买数量修改库存
	@Override
	public void updateGoodsRepositoryNum(Integer goodsId, Integer buynum) {
		// TODO Auto-generated method stub
		try {
			conn = this.getConnection();
			String sql="UPDATE tbl_goods set goods_repertory = goods_repertory - ? where goods_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, buynum);
			pst.setInt(2,goodsId);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.release(conn, pst);
		}
		
		
	}

}
