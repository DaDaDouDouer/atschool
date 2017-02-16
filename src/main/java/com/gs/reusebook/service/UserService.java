package com.gs.reusebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.User;
import com.gs.reusebook.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

	public void deleteById(int id) {
		userDao.deleteById(id);
	}
	
	public void updateUsername(String username, int id) {
		userDao.updateUsername(username, id);
	}
	
	public List<User> selectAll() {
		return userDao.selectAll();
	}
	
	public List<User> selectByName(String username) {
		return userDao.selectByName("%" + username + "%");
	}
	
	
}
