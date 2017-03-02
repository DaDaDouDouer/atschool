package com.gs.reusebook.bean;

import com.gs.reusebook.bean.base.AuthBaseBean;
import static com.gs.reusebook.util.ReusebookStatic.*;

/**
 * 
 * 商城卖家
 * 
 * @author IceAsh
 *
 */
public class Seller extends AuthBaseBean {
	
	
	/**
	 * 获取商家id的session key
	 * @return
	 */
	@Override
	public String fatchIdSessionKey(){
		return SELLER_ID_SESSION_KEY;
	}
	/**
	 * 获取商家name的session key
	 * @return
	 */
	@Override
	public String fatchNameSessionKey(){
		return SELLER_NAME_SESSION_KEY;
	}
	/**
	 * 获取商家对象的session key
	 * @return
	 */
	@Override
	public String fatchSessionKey(){
		return SELLER_SESSION_KEY;
	}
	
}
