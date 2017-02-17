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
	private UserDao userDao;

	/**
	 * 一般用户注册
	 * @param username 用户名
	 * @param password 密码
	 * @return 
	 */
	public User register(String username, String password){

		// 构建bean
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setPassword(password);
		user.setUsername(username);
		
		// 入库
		userDao.insertUser(user);
		
		return user;
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
	
	
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

	public void deleteById(int id) {
		userDao.deleteById(id);
	}
	
	public void updateUsername(String username, String id) {
		userDao.updateUsername(username, id);
	}
	
	public List<User> selectAll() {
		return userDao.selectAll();
	}
	
	public List<User> selectByName(String username) {
		return userDao.selectByName("%" + username + "%");
	}
	
	
}
