package com.gs.reusebook.util;

/**
 * 此类存放返回前台数据时使用的状态码
 * @author IceAsh
 *
 */
public class GlobalStatus {
	
	private GlobalStatus() {
	}
	
	/**
	 * 成功
	 */
	public static final int SUCCESS_200 = 200;
	/**
	 * 请求有错，比如参数错误等
	 */
	public static final int REQ_ERROR_400 = 400;
	/**
	 * 未验证
	 */
	public static final int NOT_VALIDATE_401 = 401;
	/**
	 * 服务器拒绝响应
	 */
	public static final int ACCESS_DECLINE_403 = 403;
	/**
	 * 没有找到对应的资源
	 */
	public static final int NO_RESOURCE_404 = 404;
	/**
	 * 服务器错误
	 */
	public static final int SERVICE_ERROR_500= 500;
}
