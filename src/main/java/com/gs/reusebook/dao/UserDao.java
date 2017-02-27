package com.gs.reusebook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gs.reusebook.bean.User;
import com.gs.reusebook.bean.UserInfoInMarket;

/**
 * 
 * @author IceAsh
 *
 */
public interface UserDao {
	
	public List<User> selectByName(String username);
	public int insertUser(User user);
	public void updatePassword(@Param("id") String id, @Param("password") String password);
	public UserInfoInMarket getUserInfoInMarketByUserId(String userId);
	public UserInfoInMarket getUserInfoInMarketWithAddressByUserId(String userId);
	public User selectById(String id);
	
	// ---------------test---------------
	public List<User> selectAll();
	public void deleteById(int id);
}
