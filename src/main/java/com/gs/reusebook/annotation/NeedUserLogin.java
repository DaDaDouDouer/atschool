package com.gs.reusebook.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.gs.reusebook.bean.User;
import com.gs.reusebook.bean.base.AuthBaseBean;

/**
 * 标明此方法需要登录才可以调用，
 * 在登录检查过滤器中会查找此注解<br>
 * 默认为需要User登陆
 * @author IceAsh
 *
 */
@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface NeedUserLogin {
	
	/**
	 * 表明是需要何种用户登陆，且能够参与验证的应均继承AuthBaseBean
	 * 
	 * @return
	 */
	Class<? extends AuthBaseBean>[] character() default {User.class};
}
