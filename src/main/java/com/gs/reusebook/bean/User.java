package com.gs.reusebook.bean;

/**
 * 网站一般用户
 * @author IceAsh
 *
 */
public class User {
	
	String id;
	
	String username;
	
	String password;
	
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
	
	
}
