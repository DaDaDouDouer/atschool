package com.gs.reusebook.dao.base;

import java.util.List;

import com.gs.reusebook.bean.base.AuthBaseBean;

public interface AuthBaseDao <T extends AuthBaseBean>{

	public List<T> selectByName(String username);
	public int insert(T authBaseBeanObj);
}
