package com.gs.reusebook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.bean.User;
import com.gs.reusebook.bean.base.AuthBaseBean;
import com.gs.reusebook.controller.base.AuthUserBaseController;
import com.gs.reusebook.service.AuthUserService;
import com.gs.reusebook.util.UiReturn;

/**
 * 一般用户登录注册等身份验证
 * 
 * @author IceAsh
 *
 */
@Controller
@RequestMapping("/auth/user")
public class AuthUserController extends AuthUserBaseController{

	@Autowired
	private AuthUserService authUserService;

	/**
	 * 注册操作
	 * @param username 用户名
	 * @param password 密码
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn register(@RequestBody AuthBaseBean userParams, HttpSession session) {
		UiReturn result = registerProcess(userParams, session, authUserService);
		result.setOther(User.class.getSimpleName());
		return result;
	}

	/**
	 * 登录操作   
	 * @param username 用户名
	 * @param password 密码
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn login(@RequestBody AuthBaseBean userParams, HttpSession session) {

		// TODO 校验
		return loginProcess(userParams, session, authUserService);

	}
	

	/**
	 * 注销操作
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public UiReturn logout(HttpSession session) {
		return logoutProcess(session);
	}
}
