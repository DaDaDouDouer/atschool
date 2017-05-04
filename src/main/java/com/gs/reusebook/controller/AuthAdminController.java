package com.gs.reusebook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.bean.base.AuthBaseBean;
import com.gs.reusebook.controller.base.AuthAdminBaseController;
import com.gs.reusebook.service.AuthAdminService;
import com.gs.reusebook.util.UiReturn;

/**
 * 一般用户登录注册等身份验证
 * 
 * @author IceAsh
 *
 */
@Controller
@RequestMapping("/auth/admin")
public class AuthAdminController extends AuthAdminBaseController{

	@Autowired
	private AuthAdminService authAdminService;

	// 管理员没有注册
	
	/**
	 * 登录操作   
	 * @param username 用户名
	 * @param password 密码
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn login(@RequestBody AuthBaseBean params, HttpSession session) {

		// TODO 校验
		return loginProcess(params, session, authAdminService);

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
