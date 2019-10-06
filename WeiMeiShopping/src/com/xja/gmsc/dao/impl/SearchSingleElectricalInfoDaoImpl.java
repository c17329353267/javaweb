package com.xja.gmsc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.xja.gmsc.dao.BaseDao;
import com.xja.gmsc.dao.SearchSingleElectricalInfoDao;
import com.xja.gmsc.domain.Goods;
import com.xja.gmsc.domain.GoodsImg;

public class SearchSingleElectricalInfoDaoImpl extends BaseDao implements SearchSingleElectricalInfoDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	//根据某件商品id查询单件商品全部信息
	@Override
	public Goods selectElectricalInfo(Integer electricalId) {
		// TODO Auto-generated method stub
		Goods goods = null;
		try {
			conn = this.getConnection();
			String sql="select goods_id,goods_name,typeid,goods_price,goods_curprice,goods_repertory,goods_img,goods_state,goods_introduce," 
					 +"goods_linkman,imgpath from tbl_goods left JOIN tbl_imgs on imgid=goods_img where goods_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, electricalId);
			rs = pst.executeQuery();
			while(rs.next()) {
				goods = new Goods();
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
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			this.release(conn, pst, rs);
		}
		return goods;
	}
	//根据商品id查询出改件商品所对应的中图
	@Override
	public GoodsImg selectModdlePictureAndPathByGoodId(Integer goodsId) {
		// TODO Auto-generated method stub
		GoodsImg goodsimg=null;
		try {
			conn = this.getConnection();
			String sql="select imgid,goodsid, imgpath,imgtype,parentid " + 
					"from tbl_imgs where parentid in " + 
					"(select goods_img from tbl_goods,tbl_imgs where goods_img=imgid) and goodsid = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, goodsId);
			rs = pst.executeQuery();
			while(rs.next()) {
				goodsimg = new GoodsImg();
				goodsimg.setImgId(rs.getInt("imgid"));
				goodsimg.setGoodsId(rs.getInt("goodsid"));
				goodsimg.setImgpath(rs.getString("imgpath"));
				goodsimg.setImgtype(rs.getString("imgtype"));
				goodsimg.setParentId(rs.getString("parentid"));
			}
		}catch (Exception e) {	
			e.printStackTrace();
		}finally {
			this.release(conn, pst, rs);
		}
		return goodsimg;
	}
	//	根据商品id查询出改件商品所对应的中图所对应的小图
	@Override
	public List<GoodsImg> selectAllSmallPictureWithMiddleByGoodId(Integer goodsId) {
		// TODO Auto-generated method stub
		List<GoodsImg> listsGoodsImgs = new ArrayList<>();
		try {
			conn = this.getConnection();
			String sql="SELECT imgid,goodsid, imgpath,imgtype,parentid from tbl_imgs " + 
					"where parentid = (select imgid " + 
					"from tbl_imgs where parentid in " + 
					"(select goods_img from tbl_goods,tbl_imgs where goods_img=imgid) and goodsid = ?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, goodsId);
			rs = pst.executeQuery();
			while(rs.next()) {
				GoodsImg goodsimg = new GoodsImg();
				goodsimg.setImgId(rs.getInt("imgid"));
				goodsimg.setGoodsId(rs.getInt("goodsid"));
				goodsimg.setImgpath(rs.getString("imgpath"));
				goodsimg.setImgtype(rs.getString("imgtype"));
				goodsimg.setParentId(rs.getString("parentid"));
				listsGoodsImgs.add(goodsimg);
			}
		}
		catch (Exception e) {	
			e.printStackTrace();
		}finally {
			this.release(conn, pst, rs);	
	    }
		return listsGoodsImgs;
	}

}
