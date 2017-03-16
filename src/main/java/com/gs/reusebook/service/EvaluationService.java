package com.gs.reusebook.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Evaluation;
import com.gs.reusebook.bean.Order;
import com.gs.reusebook.dao.EvaluationDao;
import com.gs.reusebook.dao.OrderDao;
import com.gs.reusebook.paramsbean.ValidatorReturnParams;
import com.gs.reusebook.util.UiReturn;
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
	
	/**
	 * 查询商品的所有评论
	 * @param goodsId
	 * @return
	 */
	public UiReturn selectAll(String goodsId){
		// TODO 参数校验
		
		return UiReturn.ok(evaluationDao.selectAll(goodsId), "查询商品评论成功");
	}
	
	/**
	 * 添加评论，不能对商品重复评论
	 * @param userId
	 * @param goodsId
	 * @param content
	 * @return
	 */
	public UiReturn addEvaluation(String userId, String goodsId, String content){
		
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
			
			evaluationDao.insertEvaluation(evaluation);
			return UiReturn.ok(evaluation, "添加评论成功");
		}
		
	}
	
}
