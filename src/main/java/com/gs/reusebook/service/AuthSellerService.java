package com.gs.reusebook.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Seller;
import com.gs.reusebook.dao.base.AuthBaseDao;
import com.gs.reusebook.service.base.AuthBaseService;
import com.gs.reusebook.util.UiReturn;
import static com.gs.reusebook.util.GlobalStatus.*;

@Service
public class AuthSellerService implements AuthBaseService{

	@Autowired
	public AuthBaseDao<Seller> sellerDao;

	/**
	 * 一般用户注册
	 * @param username 用户名
	 * @param password 密码
	 * @return 
	 */
	public UiReturn register(String username, String password){

		// 检查是否重名
		List<Seller> usersInDB = sellerDao.selectByName(username);
		if(usersInDB != null && !usersInDB.isEmpty()){
			return UiReturn.notOk(null, "名字重复", REQ_ERROR_400);
		}
		
		// 构建bean
		Seller user = new Seller();
		user.setId(UUID.randomUUID().toString());
		user.setPassword(password);
		user.setUsername(username);
		user.setCreateTime(new Date());
		
		// 入库
		sellerDao.insert(user);
		
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

		List<Seller> users = sellerDao.selectByName(username);
		if(users == null || users.isEmpty()){
			return UiReturn.notOk(null, "用户不存在", REQ_ERROR_400);
		}
		Seller userInDB = users.get(0);
		if(!password.equals(userInDB.getPassword())){
			return UiReturn.notOk(null, "密码错误", REQ_ERROR_400);
		}
		
		// 去除敏感信息
		userInDB.setPassword("");
		return UiReturn.ok(userInDB, "登录成功");
	}
	
}