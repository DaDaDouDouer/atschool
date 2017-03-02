package com.gs.reusebook.bean;

import java.util.List;

import com.gs.reusebook.bean.base.AuthBaseBean;

/**
 * 网站一般用户
 * 
 * @author IceAsh
 *
 */
public class User extends AuthBaseBean{

	private List<CartItem> cartItems;

	public User() {
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}
}
