package com.gs.reusebook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.bean.User;
import com.gs.reusebook.service.AuthService;
import com.gs.reusebook.util.UiReturn;
import static com.gs.reusebook.util.ReusebookStatic.*;

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
	private AuthService authService;

	/**
	 * 注册操作
	 * @param username 用户名
	 * @param password 密码
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn register(@RequestBody User userParams, HttpSession session) {

		// TODO 校验

		// 注册操作
		UiReturn uiReturn = authService.register(userParams.getUsername(), userParams.getPassword());

		// 如果登录成功，加入session
		if (200 == uiReturn.getStatus()) {
			User user = (User) uiReturn.getData();
			session.setAttribute(USER_SESSION_KEY, user);
			session.setAttribute(USER_ID_SESSION_KEY, user.getId());
			session.setAttribute(USER_NAME_SESSION_KEY, user.getUsername());
		}
		
		return uiReturn;
	}

	/**
	 * 登录操作   
	 * @param username 用户名
	 * @param password 密码
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn login(@RequestBody User userParams, HttpSession session) {

		// TODO 校验

		// 如果已经有同一用户登录则跳过登录
		String usernameInSession = (String) session.getAttribute(USER_NAME_SESSION_KEY);
		if (userParams.getUsername().equals(usernameInSession)) {

			return UiReturn.ok(session.getAttribute(USER_SESSION_KEY), "已登录");

		} else {

			// 登录操作
			UiReturn uiReturn = authService.login(userParams.getUsername(), userParams.getPassword());

			// 如果登录成功，加入session
			if (200 == uiReturn.getStatus()) {
				User user = (User) uiReturn.getData();
				session.setAttribute(USER_SESSION_KEY, user);
				session.setAttribute(USER_ID_SESSION_KEY, user.getId());
				session.setAttribute(USER_NAME_SESSION_KEY, user.getUsername());
			}

			return uiReturn;
		}

	}
	

	/**
	 * 注销操作
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public UiReturn logout(HttpSession session) {
		
		session.invalidate();
		
		return UiReturn.ok(null, "注销成功");
	}
}
