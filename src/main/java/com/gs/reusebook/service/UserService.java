package com.gs.reusebook.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.User;
import com.gs.reusebook.dao.UserDao;
import com.gs.reusebook.util.GlobalStatus;
import com.gs.reusebook.util.UiReturn;

@Service
public class UserService {

	@Autowired
	public UserDao userDao;

	/**
	 * 一般用户注册
	 * @param username 用户名
	 * @param password 密码
	 * @return 
	 */
	public UiReturn register(String username, String password){

		// 检查是否重名
		List<User> usersInDB = userDao.selectByName(username);
		if(usersInDB != null && !usersInDB.isEmpty()){
			return UiReturn.notOk(null, "名字重复", GlobalStatus.REQ_ERROR_400);
		}
		
		// 构建bean
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setPassword(password);
		user.setUsername(username);
		
		// 入库
		userDao.insertUser(user);
		
		// 去除敏感信息
		user.setPassword("");
		
		return UiReturn.ok(user, "注册成功");
	}
	

	/**
	 * 一般用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	public UiReturn login(String username, String password){

		List<User> users = userDao.selectByName(username);
		if(users == null || users.isEmpty()){
			return UiReturn.notOk(null, "用户不存在", GlobalStatus.REQ_ERROR_400);
		}
		User userInDB = users.get(0);
		if(!password.equals(userInDB.getPassword())){
			return UiReturn.notOk(null, "密码错误", GlobalStatus.REQ_ERROR_400);
		}
		
		// 去除敏感信息
		userInDB.setPassword("");
		return UiReturn.ok(userInDB, "登录成功");
	}
	
}
