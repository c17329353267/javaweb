package com.xja.gmsc.service.impl;

import java.util.List;

import com.xja.gmsc.dao.SearchPhoneComputerDao;
import com.xja.gmsc.dao.impl.SearchPhoneComputerDaoImpl;
import com.xja.gmsc.domain.Goods;
import com.xja.gmsc.service.ISearchPhoneComputerService;

public class SearchPhoneComputerSreviceImpl implements ISearchPhoneComputerService {

	SearchPhoneComputerDao computerDao = new SearchPhoneComputerDaoImpl();
	@Override
	public List<Goods> findAllComputerProducts() {
		// TODO Auto-generated method stub
		return computerDao.selectAllComputers();
	}

}
