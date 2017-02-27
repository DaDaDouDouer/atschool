package com.gs.reusebook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.bean.Seller;
import com.gs.reusebook.bean.User;
import com.gs.reusebook.bean.base.AuthBaseBean;
import com.gs.reusebook.controller.base.AuthSellerBaseController;
import com.gs.reusebook.service.AuthSellerService;
import com.gs.reusebook.util.UiReturn;

/**
 * 一般用户登录注册等身份验证
 * 
 * @author IceAsh
 *
 */
@Controller
@RequestMapping("/auth/seller")
public class AuthSellerController extends AuthSellerBaseController{

	@Autowired
	private AuthSellerService authSellerService;

	/**
	 * 注册操作
	 * @param username 用户名
	 * @param password 密码
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn register(@RequestBody AuthBaseBean prams, HttpSession session) {

		// TODO 校验
		return registerProcess(prams, session, authSellerService);
	}

	/**
	 * 登录操作   
	 * @param username 用户名
	 * @param password 密码
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn login(@RequestBody AuthBaseBean params, HttpSession session) {

		// TODO 校验
		return loginProcess(params, session, authSellerService);

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
