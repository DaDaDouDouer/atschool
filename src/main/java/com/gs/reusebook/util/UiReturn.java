package com.gs.reusebook.util;

import static com.gs.reusebook.util.GlobalStatus.SUCCESS_200;

/**
 * 用于生成返回给前端的标准json格式
 * 
 * @author IceAsh
 *
 */
public class UiReturn {

	private int status;
	private String msg;
	private Object data;
	private Object other;

	private UiReturn(Object data, String msg) {
		this.msg = msg;
		this.data = data;
		this.status = SUCCESS_200;
		this.other = null;
	}

	private UiReturn(Object data, String msg, Object other) {
		this.msg = msg;
		this.data = data;
		this.status = SUCCESS_200;
		this.other = other;
	}

	private UiReturn(Object data, String msg, int status) {
		this.msg = msg;
		this.data = data;
		this.status = status;
		this.other = null;
	}

	private UiReturn(Object data, String msg, int status, Object other) {
		this.msg = msg;
		this.data = data;
		this.status = status;
		this.other = other;
	}

	/**
	 * 不带other的成功
	 * 
	 * @param data
	 * @param msg
	 * @return
	 */
	public static UiReturn ok(Object data, String msg) {
		return new UiReturn(data, msg);
	}

	/**
	 * 带other的成功
	 * 
	 * @param data
	 * @param msg
	 * @return
	 */
	public static UiReturn ok(Object data, String msg, Object other) {
		return new UiReturn(data, msg, other);
	}

	/**
	 * 不带other的失败
	 * 
	 * @param data
	 * @param msg
	 * @return
	 */
	public static UiReturn notOk(Object data, String msg, int status) {
		return new UiReturn(data, msg, status);
	}

	/**
	 * 带other的失败
	 * 
	 * @param data
	 * @param msg
	 * @return
	 */
	public static UiReturn notOk(Object data, String msg, int status, Object other) {
		return new UiReturn(data, msg, status, other);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getOther() {
		return other;
	}

	public void setOther(Object other) {
		this.other = other;
	}
}
