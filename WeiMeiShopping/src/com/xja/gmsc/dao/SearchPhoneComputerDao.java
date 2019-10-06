package com.xja.gmsc.dao;

import java.util.List;

import com.xja.gmsc.domain.Goods;

public interface SearchPhoneComputerDao{

	List<Goods> selectAllComputers();

	void updateGoodsRepositoryNum(Integer goodsId, Integer integer);

}
