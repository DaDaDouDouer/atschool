package com.gs.reusebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Admin;
import com.gs.reusebook.dao.base.AuthBaseDao;
import com.gs.reusebook.service.base.AuthBaseService;
import com.gs.reusebook.util.UiReturn;
import static com.gs.reusebook.util.GlobalStatus.*;

@Service
public class AuthAdminService implements AuthBaseService{

	@Autowired
	public AuthBaseDao<Admin> adminDao;

	/**
	 * 管理员不能进行注册
	 */
	public UiReturn register(String username, String password){
		throw new UnsupportedOperationException("管理员不能进行注册");
	}

	/**
	 * 管理员登录
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	public UiReturn login(String username, String password){

		List<Admin> users = adminDao.selectByName(username);
		if(users == null || users.isEmpty()){
			return UiReturn.notOk(null, "用户不存在", REQ_ERROR_400);
		}
		Admin userInDB = users.get(0);
		if(!password.equals(userInDB.getPassword())){
			return UiReturn.notOk(null, "密码错误", REQ_ERROR_400);
		}
		
		// 去除敏感信息
		userInDB.setPassword("");
		return UiReturn.ok(userInDB, "登录成功");
	}
	
}
