package com.gs.reusebook.bean;

/**
 * 用户的收货地址
 * 
 * @author IceAsh
 *
 */
public class DeliveryAddress {
	private String id;
	private String userInfoId;

	private String address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(String userInfoId) {
		this.userInfoId = userInfoId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
