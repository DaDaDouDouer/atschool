package com.gs.reusebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.CartItem;
import com.gs.reusebook.bean.User;
import com.gs.reusebook.dao.CartItemDao;
import com.gs.reusebook.dao.UserDao;

@Service
public class TestService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private CartItemDao cartItemDao;
	

	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

	public void deleteById(int id) {
		userDao.deleteById(id);
	}
	
	public void updateUsername(String username, String id) {
		userDao.updateUsername(username, id);
	}
	
	public List<User> selectAll() {
		return userDao.selectAll();
	}
	
	public List<User> selectUserWithCartItems(String userId) {
		return userDao.selectUserWithCartItems(userId);
	}
	
	public List<User> selectByName(String username) {
		return userDao.selectByName("%" + username + "%");
	}

	public List<CartItem> selectAllWithGoods(){
		return cartItemDao.selectAllWithGoods();
	}
	
}
