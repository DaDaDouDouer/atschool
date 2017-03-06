package com.gs.reusebook.dao;

import java.util.List;

import com.gs.reusebook.bean.Admin;
import com.gs.reusebook.dao.base.AuthBaseDao;

/**
 * 
 * @author IceAsh
 *
 */
public interface AdminDao extends AuthBaseDao<Admin>{
	
	public List<Admin> selectByName(String username);
	public int insert(Admin user);
}
