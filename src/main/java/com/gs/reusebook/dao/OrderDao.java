package com.gs.reusebook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gs.reusebook.bean.Order;

public interface OrderDao {
	public List<Order> selectAllBySellerId(String sellerId);
	public List<Order> selectAllByUserId(String userId);
	
	public List<Order> selectByUserIdAndGoodsId(@Param("userId") String userId, @Param("goodsId") String goodsId);
	
	public Order selectById(String id);
	
	public Order selectByItemId(String itemId);
	
	public void updateStatus(@Param("status") int status, @Param("id") String id);
	
	public int insertOrder(Order order);
}
