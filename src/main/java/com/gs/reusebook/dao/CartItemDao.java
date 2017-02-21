package com.gs.reusebook.dao;

import java.util.List;

import com.gs.reusebook.bean.CartItem;

public interface CartItemDao {
	public List<CartItem> selectAllWithGoods();
}
