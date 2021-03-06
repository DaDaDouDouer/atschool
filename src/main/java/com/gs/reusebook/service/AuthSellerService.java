package com.gs.reusebook.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Seller;
import com.gs.reusebook.bean.base.AuthBaseBean;
import com.gs.reusebook.dao.AuthDao;
import com.gs.reusebook.dao.base.AuthBaseDao;
import com.gs.reusebook.paramsbean.ValidatorReturnParams;
import com.gs.reusebook.service.base.AuthBaseService;
import com.gs.reusebook.util.UiReturn;
import com.gs.reusebook.validator.GeneralValidator;
import com.gs.reusebook.validator.base.ValidatorType;

import static com.gs.reusebook.util.GlobalStatus.*;
import static com.gs.reusebook.validator.base.ValidatorType.AUTH_PASSWORD;
import static com.gs.reusebook.validator.base.ValidatorType.AUTH_USERNAME;

@Service
public class AuthSellerService implements AuthBaseService{

	@Autowired
	public AuthBaseDao<Seller> sellerDao;
	@Autowired
	AuthDao authDao;

	/**
	 * 卖家注册
	 * @param username 用户名
	 * @param password 密码
	 * @return 
	 */
	public UiReturn register(String username, String password, String mail){

		ValidatorReturnParams result = GeneralValidator.validate(
				new ValidatorType[]{AUTH_USERNAME, AUTH_PASSWORD}, 
				new Object[]{username, password});
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		// TODO 检查是否重名，跨表查
		List<AuthBaseBean> usersInDB = authDao.selectByName(username);
		if(usersInDB != null && !usersInDB.isEmpty()){
			return UiReturn.notOk(null, "名字重复", REQ_ERROR_400);
		}
		
		// 构建bean
		Seller user = new Seller();
		user.setId(UUID.randomUUID().toString());
		user.setPassword(password);
		user.setUsername(username);
		user.setMail(mail);
		user.setCreateTime(new Date());
		
		// 入库
		sellerDao.insert(user);
		
		// 去除敏感信息
		user.setPassword("");
		
		return UiReturn.ok(user, "注册成功");
	}
	

	/**
	 * 卖家登录
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	public UiReturn login(String username, String password){
		
		ValidatorReturnParams result = GeneralValidator.validate(
				new ValidatorType[]{AUTH_USERNAME, AUTH_PASSWORD}, 
				new Object[]{username, password});
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
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
