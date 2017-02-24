package com.gs.reusebook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gs.reusebook.bean.CartItem;

public interface CartItemDao {
	
	public CartItem selectById(String id);

	/**
	 * 搜索某用户的某商品的购物车项
	 * @param userId
	 * @param goodsId
	 * @return
	 */
	public List<CartItem> selectByGoodsId(@Param("userId") String userId, @Param("goodsId") String goodsId);
	
	public int insertCartItem(CartItem cartItem);
	
	public void deleteById(String id);
	
	public void updateGoodsCount(@Param("id") String id,@Param("goodsCount") int goodsCount);
	
	public List<CartItem> selectAllByUserId(String userId);
	
	public List<CartItem> selectAllWithGoods();
	
}
