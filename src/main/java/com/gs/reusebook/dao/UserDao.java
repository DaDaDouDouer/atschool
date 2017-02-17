package com.gs.reusebook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gs.reusebook.bean.User;

public interface UserDao {
	public int insertUser(User user);
	public List<User> selectAll();
	public List<User> selectByName(String username);
	public void deleteById(int id);
	public void updateUsername(@Param("username") String username, @Param("id") String id);
}
