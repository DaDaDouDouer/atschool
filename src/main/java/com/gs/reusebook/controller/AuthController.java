package com.gs.reusebook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.bean.User;
import com.gs.reusebook.service.UserService;
import com.gs.reusebook.util.ReusebookStatic;
import com.gs.reusebook.util.UiReturn;

/**
 * 一般用户登录注册等身份验证
 * 
 * @author IceAsh
 *
 */
@Controller
@RequestMapping("/auth/user")
public class AuthController {

	@Autowired
	private UserService userService;

	/**
	 * 注册操作
	 * @param username 用户名
	 * @param password 密码
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn register(String username, String password, HttpSession session) {

		// TODO 校验

		// 注册操作
		User user = userService.register(username, password);

		// 加入session
		session.setAttribute(ReusebookStatic.USER_SESSION_KEY, user);
		session.setAttribute(ReusebookStatic.USER_ID_SESSION_KEY, user.getId());
		session.setAttribute(ReusebookStatic.USER_NAME_SESSION_KEY, user.getUsername());

		// 去掉敏感信息，返回
		user.setPassword("");
		return UiReturn.ok(user, "注册成功");
	}

	/**
	 * 登录操作
	 * @param username 用户名
	 * @param password 密码
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn login(String username, String password, HttpSession session) {

		// TODO 校验

		// 如果已经有同一用户登录则跳过登录
		String usernameInSession = (String) session.getAttribute(ReusebookStatic.USER_NAME_SESSION_KEY);
		if (username.equals(usernameInSession)) {

			return UiReturn.ok(session.getAttribute(ReusebookStatic.USER_SESSION_KEY), "已登录");

		} else {

			// 登录操作
			UiReturn uiReturn = userService.login(username, password);

			// 如果登录成功，加入session
			if (200 == uiReturn.getStatus()) {
				User user = (User) uiReturn.getData();
				session.setAttribute(ReusebookStatic.USER_SESSION_KEY, user);
				session.setAttribute(ReusebookStatic.USER_ID_SESSION_KEY, user.getId());
				session.setAttribute(ReusebookStatic.USER_NAME_SESSION_KEY, user.getUsername());
			}

			return uiReturn;
		}

	}
}
