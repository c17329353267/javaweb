package com.xja.gmsc.service;

import java.util.List;

import com.xja.gmsc.domain.Goods;
import com.xja.gmsc.domain.GoodsImg;

public interface ISearchSingleElectricalInfoService {

	Goods searchSingleGoodInfo(Integer electricalId);

	GoodsImg findModdlePictureAndPathByGoodId(Integer goodsId);

	List<GoodsImg> findAllSmallPictureWithMiddleByGoodId(Integer goodsId);

}
