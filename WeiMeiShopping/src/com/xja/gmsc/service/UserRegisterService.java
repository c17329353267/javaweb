package com.xja.gmsc.service;

import java.util.Map;

import com.xja.gmsc.domain.Register;

public interface UserRegisterService {

	void addUser(Register reg);

	Register findRegisterByNameAndPwd(String loginname, String loginpwd);

}
