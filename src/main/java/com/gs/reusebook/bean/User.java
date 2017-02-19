package com.gs.reusebook.bean;

import java.util.Date;

/**
 * 网站一般用户
 * 
 * @author IceAsh
 *
 */
public class User {

	private String id;

	private String username;

	private String password;

	private Date createTime;

	public User() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
