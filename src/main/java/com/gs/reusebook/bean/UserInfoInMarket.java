package com.gs.reusebook.bean;

import java.util.List;

/**
 * 当用户处在商城时的用户信息
 * 
 * @author IceAsh
 *
 */
public class UserInfoInMarket {
	
	private String id;

	private String userId;

	private List<DeliveryAddress> deliveryAddresses;
	
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

	public List<DeliveryAddress> getDeliveryAddresses() {
		return deliveryAddresses;
	}
	
	public void setDeliveryAddresses(List<DeliveryAddress> deliveryAddresses) {
		this.deliveryAddresses = deliveryAddresses;
	}
	
}
