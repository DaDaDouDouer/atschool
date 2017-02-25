package com.gs.reusebook.bean;

import java.util.List;

/**
 * 
 * 用户订单
 * 
 * @author IceAsh
 *
 */
public class Order {
	private String id;
	
	private String userId;
	private String sellerId;
	
	private int status;

	private List<OrderItem> orderItems;
	
	/*
	 * 其他订单信息
	 */
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	
}
