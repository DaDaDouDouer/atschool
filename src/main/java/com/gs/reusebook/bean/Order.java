package com.gs.reusebook.bean;

import java.util.Date;
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
	private String sellerName;
	private String userName;
	
	private String address;
	
	private Date createTime;
	
	private double totalPrice = 0.0;
	
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

	
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
	public String getSellerName() {
		return sellerName;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
