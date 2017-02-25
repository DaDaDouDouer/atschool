package com.gs.reusebook.util;

/**
 * 保存一些项目需要的常量
 * @author IceAsh
 *
 */
public class ReusebookStatic {
	
	private ReusebookStatic() {
	}
	
	/**
	 * session中保存user的键
	 */
	public final static String USER_SESSION_KEY = "thenowuser";
	
	/**
	 * session中保存user的id的键
	 */
	public final static String USER_ID_SESSION_KEY = "thenowuserid";
	
	/**
	 * session中保存user的name的键
	 */
	public final static String USER_NAME_SESSION_KEY = "thenowusername";
	
	
	/**
	 * 数据库表名
	 */
	public final static String TABLE_NAME_BOOK = "tab_book";
	
	/**
	 * 订单状态
	 */
	public final static int ORDER_STATUS_START = 1000;
}
