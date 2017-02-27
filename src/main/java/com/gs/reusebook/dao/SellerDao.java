package com.gs.reusebook.dao;

import java.util.List;

import com.gs.reusebook.bean.User;
import com.gs.reusebook.dao.base.AuthBaseDao;

/**
 * 
 * @author IceAsh
 *
 */
public interface SellerDao extends AuthBaseDao<User>{
	
	public List<User> selectByName(String username);
	public int insert(User user);
}
