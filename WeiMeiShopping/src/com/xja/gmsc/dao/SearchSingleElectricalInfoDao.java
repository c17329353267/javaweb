package com.xja.gmsc.dao;

import java.util.List;

import com.xja.gmsc.domain.Goods;
import com.xja.gmsc.domain.GoodsImg;

public interface SearchSingleElectricalInfoDao {

	Goods selectElectricalInfo(Integer electricalId);

	GoodsImg selectModdlePictureAndPathByGoodId(Integer goodsId);

	List<GoodsImg> selectAllSmallPictureWithMiddleByGoodId(Integer goodsId);

}
