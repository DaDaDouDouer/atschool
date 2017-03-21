package com.gs.reusebook.bean.base;

/**
 * 一个类实现此接口的目的应该是：<br>
 * 它需要返回与身份验证的bean相关的各种session key
 * @author IceAsh
 *
 */
public interface FatchAuthSessionKey {

	public String fatchIdSessionKey();

	public String fatchNameSessionKey();

	public String fatchSessionKey();
}
