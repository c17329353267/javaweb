package com.xja.gmsc.service.impl;

import java.util.Map;

import com.xja.gmsc.dao.UserRegisterDao;
import com.xja.gmsc.dao.impl.UserRegisterDaoImpl;
import com.xja.gmsc.domain.Register;
import com.xja.gmsc.service.UserRegisterService;

public class UserRegisterServiceImpl implements UserRegisterService{

	private UserRegisterDao userRegisterDao = new UserRegisterDaoImpl(); 
	@Override
	public void addUser(Register reg) {
		// TODO Auto-generated method stub
		userRegisterDao.insertUser(reg);
	}
	@Override
	public Register findRegisterByNameAndPwd(String loginname, String loginpwd) {
		// TODO Auto-generated method stub
		return userRegisterDao.selectRegisterByNameAndPwd(loginname,loginpwd);
	}

}
