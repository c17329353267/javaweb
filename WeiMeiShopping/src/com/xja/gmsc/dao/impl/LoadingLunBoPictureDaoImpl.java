package com.xja.gmsc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.xja.gmsc.dao.BaseDao;
import com.xja.gmsc.dao.LoadingLunBoPictureDao;
import com.xja.gmsc.domain.Goods;
import com.xja.gmsc.domain.LoadPicture;

public class LoadingLunBoPictureDaoImpl extends BaseDao implements LoadingLunBoPictureDao {

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	@Override
	public List<LoadPicture> selectAllLunBoPictures() {
		List<LoadPicture> listsPictures = new ArrayList<LoadPicture>();
		try {
			conn = this.getConnection();
			String sql="select lunbo_id,lunbo_url,lunbo_type from tbl_lunbo";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				LoadPicture loadPicture = new LoadPicture();
				loadPicture.setLunboId(rs.getInt("lunbo_id"));
				loadPicture.setLunboUrl(rs.getString("lunbo_url"));
				loadPicture.setLunboType(rs.getString("lunbo_type"));
				listsPictures.add(loadPicture);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.release(conn, pst, rs);
		}
		return listsPictures;
	}

}
