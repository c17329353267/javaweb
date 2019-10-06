package com.xja.gmsc.dao;

import java.util.Map;

import com.xja.gmsc.domain.Register;

public interface UserRegisterDao {

	public void insertUser(Register reg);

	public Register selectRegisterByNameAndPwd(String loginname, String loginpwd); 

}
