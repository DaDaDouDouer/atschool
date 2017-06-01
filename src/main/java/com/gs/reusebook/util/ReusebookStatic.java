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
	public final static String CHECK_CODE_SESSION_KEY = "thecheckcode";
	
	
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
	 * session中保存seller的键
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
	public final static String DEFAULT_TYPE = "default_type";
	/**
	 * 默认书的基本类型，每本书都会有一个这个类型
	 */
	public final static String DEFAULT_TYPE_BASE = "default_type_base";
	/**
	 * 默认书的基本类型id，每本书都会有一个这个类型的id
	 */
	public final static String DEFAULT_TYPE_BASE_ID = "default_type_base_id";
	/**
	 * 默认书的类型ID，每本书都会有一个这个类型
	 */
	public final static String DEFAULT_TYPE_ID = "09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab";
	
	
	
	
	
	

	/**
	 * 首页商铺的图片地址
	 */
	public final static String INDEX_Seller_PASSWORD = "index";
	/**
	 * 首页商铺的名字
	 */
	public final static String INDEX_Seller_NAME = "index";
	/**
	 * 首页商铺的id
	 */	
	public final static String INDEX_SELLER_ID = "586c450b-1d91-48af-8e1b-a12b8edfe03c";
	
	/**
	 * 首页商铺的图片地址
	 */
	public final static String INDEX_SHOP_IMGURL = "";
	/**
	 * 首页商铺的名字
	 */
	public final static String INDEX_SHOP_NAME = "首页";
	/**
	 * 首页商铺的id
	 */	
	public final static String INDEX_SHOP_ID = "b2e58fd1-41e0-460c-ad90-347c8f4c9709";
	
	
	
	
	/**
	 * 订单状态，用户已下单
	 */
	public final static int ORDER_STATUS_START = 1000;
	/*
	 * 订单状态，用户已付款
	 */
	public final static int ORDER_STATUS_PAYED  = 1001;
	/*
	 * 订单状态，卖家确认付款
	 */
	public final static int ORDER_STATUS_PAYED_OK  = 1002;
	/*
	 * 订单状态，卖家已发货
	 */
	public final static int ORDER_STATUS_SENDED  = 1003;
	/*
	 * 订单状态，交易完成
	 */
	public final static int ORDER_STATUS_END  = 1004;

	
	
	
	
	/**
	 * 分页查询商品的每页显示最小值
	 */
	public final static int CUT_PAGE_LIMIT_MIN = 10;
	/**
	 * 分页查询商品的每页显示最大值
	 */
	public final static int CUT_PAGE_LIMIT_MAX = 30;
}
