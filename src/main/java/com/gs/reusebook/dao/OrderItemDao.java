package com.gs.reusebook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gs.reusebook.bean.OrderItem;

public interface OrderItemDao {
	public int insertOrderItem(OrderItem orderItem);
	public OrderItem selectById(String id);
	public List<OrderItem> selectByOrderId(String id);
	public void updateStatus(@Param("status") int status, @Param("id") String id);
	public void deleteOrderItem(String id);
}
