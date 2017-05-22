package com.gs.reusebook.bean;

import static com.gs.reusebook.util.ReusebookStatic.*;

import com.gs.reusebook.bean.base.AuthBaseBean;

/**
 * 
 * 网站管理员
 * 
 * @author IceAsh
 *
 */
public class Admin extends AuthBaseBean{

	/**
	 * 获取管理员用户id的session key
	 * @return
	 */
	@Override
	public String fatchIdSessionKey(){
		return ADMIN_ID_SESSION_KEY;
	}
	/**
	 * 获取管理员用户name的session key
	 * @return
	 */
	@Override
	public String fatchNameSessionKey(){
		return ADMIN_NAME_SESSION_KEY;
	}
	/**
	 * 获取管理员用户对象的session key
	 * @return
	 */
	@Override
	public String fatchSessionKey(){
		return ADMIN_SESSION_KEY;
	}
}
