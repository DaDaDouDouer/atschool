package com.gs.reusebook.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Evaluation;
import com.gs.reusebook.bean.Order;
import com.gs.reusebook.dao.EvaluationDao;
import com.gs.reusebook.dao.OrderDao;
import com.gs.reusebook.dao.SellerDao;
import com.gs.reusebook.paramsbean.CutPageValidatorReturnParams;
import com.gs.reusebook.paramsbean.ValidatorReturnParams;
import com.gs.reusebook.util.UiReturn;
import com.gs.reusebook.validator.CutPageParamsValidator;
import com.gs.reusebook.validator.GeneralValidator;
import com.gs.reusebook.validator.base.ValidatorType;

import static com.gs.reusebook.util.GlobalStatus.*;
import static com.gs.reusebook.validator.base.ValidatorType.*;

@Service
public class EvaluationService {
	
	@Autowired
	private EvaluationDao evaluationDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private SellerDao sellerDao;
	
	/**
	 * 查询商品的所有评论
	 * @param goodsId
	 * @return
	 */
	public UiReturn selectAll(String goodsId){
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(ValidatorType.PKID, goodsId);
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		return UiReturn.ok(evaluationDao.selectAll(goodsId), "查询商品评论成功");
	}
	

	public UiReturn selectAllBySellerId(String sellerId, Integer pageNo, Integer limit){
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(ValidatorType.PKID, sellerId);
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		int goodsAllCount = evaluationDao.selectCountBySellerId(sellerId);
		
		// 特殊的分页校验
		CutPageValidatorReturnParams rst = 
				CutPageParamsValidator.validate(pageNo, limit, goodsAllCount);

		List<Evaluation> evaluations = evaluationDao.selectAllBySellerId(sellerId, rst.offset, rst.limit); 
		// 将查询到的总页数放入other中返回
		Map<String, Integer> otherMap = new HashMap<String, Integer>(1);
		otherMap.put("pageAllCount", rst.pageAllCount);
		
		
		return UiReturn.ok(evaluations, "查询商品评论成功", otherMap);
	}
	
	
	/**
	 * 添加评论，不能对商品重复评论
	 * @param userId
	 * @param goodsId
	 * @param content
	 * @return
	 */
	public UiReturn addEvaluation(String userId, String goodsId, String content, String username){
		
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(
				new ValidatorType[]{PKID, PKID, STRING_255}, 
				new Object[]{userId, goodsId, content});
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		// 只能对购买过的商品添加评论
		List<Order> orders = orderDao.selectByUserIdAndGoodsId(userId, goodsId);
		if(orders == null || orders.isEmpty()){
			return UiReturn.notOk("", "只能对购买过的商品添加评论", REQ_ERROR_400);
		}
		
		// 不能对商品重复评论
		List<Evaluation> evaluations = evaluationDao.selectByUserIdAndGoodsId(userId, goodsId);
		if(evaluations != null && !evaluations.isEmpty()){
			return UiReturn.notOk("", "不能对商品重复添加评论", REQ_ERROR_400);
		}else{
			Evaluation evaluation = new Evaluation();
			evaluation.setId(UUID.randomUUID().toString());
			evaluation.setGoodsId(goodsId);
			evaluation.setUserId(userId);
			evaluation.setContent(content);
			evaluation.setCreateTime(new Date());
			
			evaluation.setUsername(username);
			evaluation.setSellername(sellerDao.selectByGoodsId(goodsId).getUsername());
			
			evaluationDao.insertEvaluation(evaluation);
			return UiReturn.ok(evaluation, "添加评论成功");
		}
		
	}
	
}
