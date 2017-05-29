package com.gs.reusebook.bean.base;

import java.util.Date;

public class AuthBaseBean implements FatchAuthSessionKey{

	private String id;

	private String username;

	private String password;

	private Date createTime;

	private String mail;
	
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
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String fatchIdSessionKey() {
		throw new UnsupportedOperationException("父类不支持此方法，子类未实现。");
	}
	public String fatchNameSessionKey() {
		throw new UnsupportedOperationException("父类不支持此方法，子类未实现。");
	}
	public String fatchSessionKey() {
		throw new UnsupportedOperationException("父类不支持此方法，子类未实现。");
	}
	
}

