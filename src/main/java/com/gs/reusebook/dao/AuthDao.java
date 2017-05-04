package com.gs.reusebook.dao;

import java.util.List;

import com.gs.reusebook.bean.base.AuthBaseBean;

public interface AuthDao {

	public List<AuthBaseBean> selectByName(String username);
	
}
