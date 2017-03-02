package com.gs.reusebook.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 标明此方法需要卖家登录才可以调用，
 * 在登录检查过滤器中会查找此注解
 * @author IceAsh
 *
 */
@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface NeedSellerLogin {

}
