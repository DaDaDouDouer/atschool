package com.gs.reusebook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.CartItem;
import com.gs.reusebook.bean.Goods;
import com.gs.reusebook.dao.CartItemDao;
import com.gs.reusebook.dao.GoodsDao;
import com.gs.reusebook.paramsbean.ValidatorReturnParams;
import com.gs.reusebook.util.UiReturn;
import com.gs.reusebook.validator.GeneralValidator;
import com.gs.reusebook.validator.base.ValidatorType;

import static com.gs.reusebook.util.GlobalStatus.*;
import static com.gs.reusebook.validator.base.ValidatorType.*;


@Service
public class CartItemService {

	@Autowired
	private CartItemDao cartItemDao;
	@Autowired
	private GoodsDao goodsDao;
	
	/**
	 * 返回一个用户的所有购物车项
	 * @return
	 */
	public UiReturn selectAll(String userId){
		
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(ValidatorType.PKID, userId);
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		return UiReturn.ok(cartItemDao.selectAllByUserId(userId), "返回购物车项成功");
	}
	
	/**
	 * 把一个商品添加到购物车
	 * @param userId
	 * @param goodsId
	 * @param goodsCount
	 * @return
	 */
	public UiReturn addToCart(String userId, String goodsId, Integer goodsCount){
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(
				new ValidatorType[]{PKID, PKID, INT_POSITIVE}, 
				new Object[]{userId, goodsId, goodsCount});
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		// 不能重复添加商品
		List<CartItem> cartItems = cartItemDao.selectByGoodsId(userId, goodsId);
		if(cartItems != null && !cartItems.isEmpty()){
			return UiReturn.notOk("", "不能向购物车中添加重复商品", REQ_ERROR_400);
		}
		
		// 数量校验
		Goods goods = goodsDao.selectById(goodsId);
		if(goodsCount > goods.getCount()){
			return UiReturn.notOk("", "商品数量不够，不能添加至购物车", REQ_ERROR_400);
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setId(UUID.randomUUID().toString());
		cartItem.setUserId(userId);
		cartItem.setGoodsId(goodsId);
		cartItem.setGoodsCount(goodsCount);
		
		cartItemDao.insertCartItem(cartItem);
		
		return UiReturn.ok(cartItem, "添加至购物车成功");
		
	}
	
	/**
	 * 删除购物车中某个特定商品的项
	 * @param userId
	 * @param goodId
	 * @return
	 */
	public UiReturn deleteFromCart(String userId, String goodId){
		
		// TODO 为将来准备的接口
		return null;
	}

	/**
	 * 通过购物车项id删除某项
	 * @param userId
	 * @param cartItemId
	 * @return
	 */
	public UiReturn deleteCartItem(String userId, String cartItemId){
		
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(
				new ValidatorType[]{PKID, PKID}, 
				new Object[]{userId, cartItemId});
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		CartItem cartItem = cartItemDao.selectById(cartItemId);
		// TODO 为空校验
		
		if(cartItem.getUserId().equals(userId)){
			cartItemDao.deleteById(cartItemId);
			return UiReturn.ok("", "删除购物车项成功");
		}else{
			return UiReturn.notOk("", "不能删除其它用户的购物车项", REQ_ERROR_400);
		}
		
	}
	
	/**
	 * 修改购物车项的商品数量
	 * @param userId
	 * @param cartItemId
	 * @param goodsCount
	 * @return
	 */
	public UiReturn updateGoodsCount(String userId, String cartItemId, Integer goodsCount){
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(
				new ValidatorType[]{PKID, PKID, INT_POSITIVE}, 
				new Object[]{userId, cartItemId, goodsCount});
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}

		CartItem cartItem = cartItemDao.selectById(cartItemId);
		// TODO 为空校验
		
		if(cartItem.getUserId().equals(userId)){
			cartItemDao.updateGoodsCount(cartItemId, goodsCount);
			return UiReturn.ok("", "修改购物车商品数量成功");
		}else{
			return UiReturn.notOk("", "不能修改其它用户的购物车商品数量", REQ_ERROR_400);
		}
	}

	/**
	 * 替换当前用户所有购物车项
	 * @param userId
	 * @param cartItems
	 * @return
	 */
	public UiReturn updateAll(String userId, List<CartItem> cartItems) {
		// userId校验
		ValidatorReturnParams result = GeneralValidator.validate(PKID, userId);
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		if(cartItems == null){
			cartItems = new ArrayList<CartItem>();
		}
		// 校验数量和商品id
		List<ValidatorType> types = new ArrayList<ValidatorType>();
		List<Object> params = new ArrayList<Object>();
		for(CartItem cartItem : cartItems){
			params.add(cartItem.getGoodsId());
			params.add(cartItem.getGoodsCount());
			types.add(PKID);
			types.add(INT_POSITIVE);
		}
		int size = types.size();
		ValidatorReturnParams result2 = GeneralValidator.validate(
				types.toArray(new ValidatorType[size]), 
				params.toArray(new Object[size]));
		if(!result2.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		// 检验每个goods是否都存在
		for(CartItem cartItem : cartItems){
			Goods goods = goodsDao.selectById(cartItem.getGoodsId());
			// 如果商品不存在则返回失败，同时在other中返回不存在的id
			// TODO （当前只会返回一个不存在的id）
			if(goods == null){
				return UiReturn.notOk(null, "商品不存在", REQ_ERROR_400, cartItem.getGoodsId());
			}
		}
		
		// 删除所有旧购物车项
		cartItemDao.deleteAllByUserId(userId);
		
		// 字段赋值，入库
		for(CartItem cartItem : cartItems){
			cartItem.setId(UUID.randomUUID().toString());
			cartItem.setUserId(userId);
			cartItemDao.insertCartItem(cartItem);
		}
		
		return UiReturn.ok(null, "更新购物车成功");
	}

}
