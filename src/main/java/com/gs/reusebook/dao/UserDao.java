package com.gs.reusebook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gs.reusebook.bean.User;
import com.gs.reusebook.bean.UserInfoInMarket;
import com.gs.reusebook.dao.base.AuthBaseDao;

/**
 * 
 * @author IceAsh
 *
 */
public interface UserDao extends AuthBaseDao<User>{
	
	public List<User> selectAndPagedByName(@Param("username")String username,@Param("offset") int offset, @Param("limit") int limit);
	public List<User> selectByName(String username);
	public int insert(User user);
	public void updatePassword(@Param("id") String id, @Param("password") String password);
	public UserInfoInMarket getUserInfoInMarketByUserId(String userId);
	public UserInfoInMarket getUserInfoInMarketWithAddressByUserId(String userId);
	public User selectById(String id);
	public void deleteUser(String id);
	/**
	 * 模糊查询数量，得到selectAndPagedByName的数量
	 * @param name
	 * @return
	 */
	public Integer selectCountByName(String username);
	// ---------------test---------------
	public List<User> selectAll();
}
