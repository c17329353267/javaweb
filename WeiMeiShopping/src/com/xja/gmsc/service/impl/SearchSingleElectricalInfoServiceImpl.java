package com.xja.gmsc.service.impl;

import java.util.List;

import com.xja.gmsc.dao.SearchSingleElectricalInfoDao;
import com.xja.gmsc.dao.impl.SearchSingleElectricalInfoDaoImpl;
import com.xja.gmsc.domain.Goods;
import com.xja.gmsc.domain.GoodsImg;
import com.xja.gmsc.service.ISearchSingleElectricalInfoService;

public class SearchSingleElectricalInfoServiceImpl implements ISearchSingleElectricalInfoService{

	SearchSingleElectricalInfoDao singleElectricalInfoDao = new SearchSingleElectricalInfoDaoImpl();
	@Override
	public Goods searchSingleGoodInfo(Integer electricalId) {
		// TODO Auto-generated method stub
		return singleElectricalInfoDao.selectElectricalInfo(electricalId);
	}
	@Override
	public GoodsImg findModdlePictureAndPathByGoodId(Integer goodsId) {
		// TODO Auto-generated method stub
		return singleElectricalInfoDao.selectModdlePictureAndPathByGoodId(goodsId);
	}
	@Override
	public List<GoodsImg> findAllSmallPictureWithMiddleByGoodId(Integer goodsId) {
		// TODO Auto-generated method stub
		return singleElectricalInfoDao.selectAllSmallPictureWithMiddleByGoodId(goodsId);
	}

}
