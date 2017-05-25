package com.gs.reusebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.DeliveryAddress;
import com.gs.reusebook.bean.User;
import com.gs.reusebook.bean.UserInfoInMarket;
import com.gs.reusebook.dao.DeliveryAddressDao;
import com.gs.reusebook.dao.UserDao;
import com.gs.reusebook.paramsbean.CutPageValidatorReturnParams;
import com.gs.reusebook.paramsbean.ValidatorReturnParams;
import com.gs.reusebook.util.UiReturn;
import com.gs.reusebook.validator.CutPageParamsValidator;
import com.gs.reusebook.validator.GeneralValidator;
import com.gs.reusebook.validator.base.ValidatorType;

import static com.gs.reusebook.util.GlobalStatus.*;
import static com.gs.reusebook.validator.base.ValidatorType.PKID;
import static com.gs.reusebook.validator.base.ValidatorType.AUTH_PASSWORD;
import static com.gs.reusebook.validator.base.ValidatorType.STRING_255;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DeliveryAddressDao deliveryAddressDao;
	
	public UiReturn selectAndPagedByName(String username, Integer pageNo, Integer limit){
		if(username == null)
			username = "";
		// 获取到可查询到的用户总量
		int userAllCount = userDao.selectCountByName("%"+ username + "%");
				
		// 特殊的分页校验
		CutPageValidatorReturnParams rst = 
		CutPageParamsValidator.validate(pageNo, limit, userAllCount);
	
		// 分页查询用户
		List<User> user = userDao.selectAndPagedByName("%"+ username + "%", rst.offset, rst.limit); 
				
		// 将查询到的总页数放入other中返回
		Map<String, Integer> otherMap = new HashMap<String, Integer>(1);
		otherMap.put("pageAllCount", rst.pageAllCount);
				
		return UiReturn.ok(user, "获取用户成功", otherMap);		
	}
	
	public UiReturn getUserInfoInMarketByUserId(String userId){
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(PKID, userId);
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}

		// TODO 可能要进行为空校验
		return UiReturn.ok(userDao.getUserInfoInMarketWithAddressByUserId(userId), "获取个人信息成功");
	}
	
	/**
	 * 修改密码，旧密码和session中的user比较<br>
	 * 如果修改成功则返回修改之后的user
	 * @param user session中储存的user
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 * @return
	 */
	public UiReturn changePassword(String userId, String oldPassword, String newPassword){
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(
				new ValidatorType[]{PKID, AUTH_PASSWORD, AUTH_PASSWORD}, 
				new Object[]{userId, oldPassword, newPassword});
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		User user = userDao.selectById(userId);
		
		// 校验是否为空
		if(user == null){
			return UiReturn.notOk(null, "不存在此用户", REQ_ERROR_400);
		}
		
		if(user.getPassword().equals(oldPassword)){
			userDao.updatePassword(user.getId(), newPassword);
			
			user.setPassword("");
			return UiReturn.ok(user, "修改成功");
		}else{
			return UiReturn.notOk(null, "旧密码输入错误", REQ_ERROR_400);
		}
	}
	
	/**
	 * 添加收货地址
	 * @param userId
	 * @param deliveryAddress
	 * @return
	 */
	public UiReturn addAddress(String userId, DeliveryAddress deliveryAddress){
		
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(
				new ValidatorType[]{PKID, STRING_255}, 
				new Object[]{userId, deliveryAddress});
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		UserInfoInMarket userInfoInMarket = userDao.getUserInfoInMarketByUserId(userId);
		// 校验是否为空
		if(userInfoInMarket == null){
			return UiReturn.notOk(null, "不存在此用户", REQ_ERROR_400);
		}
		
		deliveryAddress.setId(UUID.randomUUID().toString());
		deliveryAddress.setUserInfoId(userInfoInMarket.getId());
		
		deliveryAddressDao.insertDeliveryAddress(deliveryAddress);
		
		return UiReturn.ok(null, "添加收货地址成功");
	}
	
	/**
	 * 通过地址id删除收货地址
	 * @param deliveryAddressId
	 * @return
	 */
	public UiReturn deleteAddress(String userId, String deliveryAddressId){
		
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(
				new ValidatorType[]{PKID, PKID}, 
				new Object[]{userId, deliveryAddressId});
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		// 不能删除别人的收货地址
		UserInfoInMarket userInfoInMarket = userDao.getUserInfoInMarketByUserId(userId);
		DeliveryAddress deliveryAddress = deliveryAddressDao.selectById(deliveryAddressId);
		
		if(userInfoInMarket.getId().equals(deliveryAddress.getUserInfoId())){
			deliveryAddressDao.deleteDeliveryAddress(deliveryAddress.getId());
			return UiReturn.ok(null, "删除收货地址成功");
		}else{
			return UiReturn.notOk(null, "不能删除其他用户的收货地址", REQ_ERROR_400);
		}
		
	}
	/**
	 * 根据Id删除user
	 * @param userId
	 * @return
	 */
	public UiReturn deleteUser(String userId){
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(
				new ValidatorType[]{PKID}, 
				new Object[]{userId});
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		userDao.deleteUser(userId);
		return UiReturn.ok(null, "删除用户成功");
			
	}
}
