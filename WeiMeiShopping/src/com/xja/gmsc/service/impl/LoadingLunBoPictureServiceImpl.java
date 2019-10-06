package com.xja.gmsc.service.impl;

import java.util.List;

import com.xja.gmsc.dao.LoadingLunBoPictureDao;
import com.xja.gmsc.dao.impl.LoadingLunBoPictureDaoImpl;
import com.xja.gmsc.domain.LoadPicture;
import com.xja.gmsc.service.ILoadingLunBoPictureService;

public class LoadingLunBoPictureServiceImpl implements ILoadingLunBoPictureService {

	LoadingLunBoPictureDao lunbopicturedao = new LoadingLunBoPictureDaoImpl();
	@Override
	public List<LoadPicture> findAllLunBoPicture() {
		// TODO Auto-generated method stub
		return lunbopicturedao.selectAllLunBoPictures();
	}

}
