package com.gs.reusebook.dao;

import java.util.List;

import com.gs.reusebook.bean.Order;

public interface OrderDao {
	public List<Order> selectAllBySellerId(String sellerId);
	public List<Order> selectAllByUserId(String sellerId);
	public int insertOrder(Order order);
}
