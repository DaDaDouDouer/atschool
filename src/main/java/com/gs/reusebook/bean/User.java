package com.gs.reusebook.bean;

/**
 * 网站一般用户
 * @author IceAsh
 *
 */
public class User {
	
	int id;
	
	String username;
	
	String password;
	
	public User() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
