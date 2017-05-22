package com.gs.reusebook.service;

import static com.gs.reusebook.util.GlobalStatus.REQ_ERROR_400;
import static com.gs.reusebook.validator.base.ValidatorType.AUTH_PASSWORD;
import static com.gs.reusebook.validator.base.ValidatorType.PKID;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Seller;
import com.gs.reusebook.bean.User;
import com.gs.reusebook.dao.SellerDao;
import com.gs.reusebook.paramsbean.CutPageValidatorReturnParams;
import com.gs.reusebook.paramsbean.ValidatorReturnParams;
import com.gs.reusebook.util.UiReturn;
import com.gs.reusebook.validator.CutPageParamsValidator;
import com.gs.reusebook.validator.GeneralValidator;
import com.gs.reusebook.validator.base.ValidatorType;

@Service
public class SellerService {
	@Autowired
	private SellerDao sellerDao;
	
	public UiReturn searchAndPagedByName(String username, Integer pageNo, Integer limit){
		
		if(username == null)
			username = "";
		// 获取到可查询到的卖家总量
		int sellerAllCount = sellerDao.selectCountByName("%"+ username + "%");
						
		// 特殊的分页校验
		CutPageValidatorReturnParams rst = 
		CutPageParamsValidator.validate(pageNo, limit, sellerAllCount);
			
		// 分页查询卖家
		List<User> seller = sellerDao.selectAndPagedByName("%"+ username + "%", rst.offset, rst.limit); 
						
		// 将查询到的总页数放入other中返回
		Map<String, Integer> otherMap = new HashMap<String, Integer>(1);
		otherMap.put("pageAllCount", rst.pageAllCount);
						
		return UiReturn.ok(seller, "获取卖家成功", otherMap);	
	}
	public UiReturn updatePassword(String sellerId, String password){
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(
			new ValidatorType[]{PKID, AUTH_PASSWORD}, 
			new Object[]{sellerId, password});
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		sellerDao.updatePassword(sellerId, password);
		
		return UiReturn.ok(null, "修改成功");
	}
	public UiReturn deleteSeller(String sellerId){
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(
				new ValidatorType[]{PKID}, 
				new Object[]{sellerId});
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		sellerDao.deleteSeller(sellerId);
		return UiReturn.ok(null, "删除卖家成功");
	}
}
