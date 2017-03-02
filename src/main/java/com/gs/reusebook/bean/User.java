package com.gs.reusebook.bean;

import java.util.List;

import com.gs.reusebook.bean.base.AuthBaseBean;

import static com.gs.reusebook.util.ReusebookStatic.*;

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
	
	

	/**
	 * 获取一般用户id的session key
	 * @return
	 */
	@Override
	public String fatchIdSessionKey(){
		return USER_ID_SESSION_KEY;
	}
	/**
	 * 获取获取一般用户name的session key
	 * @return
	 */
	@Override
	public String fatchNameSessionKey(){
		return USER_NAME_SESSION_KEY;
	}
	/**
	 * 获取获取一般用户对象的session key
	 * @return
	 */
	@Override
	public String fatchSessionKey(){
		return USER_SESSION_KEY;
	}
}
