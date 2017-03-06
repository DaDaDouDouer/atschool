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
	 * session中保存user的键
	 */
	public final static String SELLER_SESSION_KEY = "thenowseller";
	/**
	 * session中保存user的id的键
	 */
	public final static String SELLER_ID_SESSION_KEY = "thenowsellerid";
	/**
	 * session中保存user的name的键
	 */
	public final static String SELLER_NAME_SESSION_KEY = "thenowsellername";
	
	
	
	
	
	

	/**
	 * session中保存admin的键
	 */
	public final static String ADMIN_SESSION_KEY = "thenowadmin";
	/**
	 * session中保存user的id的键
	 */
	public final static String ADMIN_ID_SESSION_KEY = "thenowadminid";
	/**
	 * session中保存user的name的键
	 */
	public final static String ADMIN_NAME_SESSION_KEY = "thenowadminname";
	
	
	
	
	
	
	
	/**
	 * 数据库表名
	 */
	public final static String TABLE_NAME_BOOK = "tab_book";
	
	
	
	
	
	
	
	/**
	 * 默认书的类型，每本书都会有一个这个类型
	 */
	public final static String DEFAULT_BOOK_TYPE = "default_book_type";
	/**
	 * 默认书的基本，每本书都会有一个这个类型
	 */
	public final static String DEFAULT_BOOK_TYPE_BASE = "default_book_type_base";
	/**
	/**
	 * 默认书的类型ID，每本书都会有一个这个类型
	 */
	public final static String DEFAULT_BOOK_TYPE_ID = "09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab";
	
	
	
	
	
	
	/**
	 * 订单状态
	 */
	public final static int ORDER_STATUS_START = 1000;
}
