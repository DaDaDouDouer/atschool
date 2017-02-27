package com.gs.reusebook.bean;

import java.util.Date;
import java.util.List;

import com.gs.reusebook.bean.base.AuthBaseBean;

/**
 * 网站一般用户
 * 
 * @author IceAsh
 *
 */
public class User extends AuthBaseBean{

	private String id;

	private String username;

	private String password;

	private Date createTime;

	private List<CartItem> cartItems;

	public User() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}
}
