package com.gs.reusebook.controller.base;

import javax.servlet.http.HttpSession;

import com.gs.reusebook.bean.User;
import com.gs.reusebook.service.base.AuthBaseService;
import com.gs.reusebook.util.UiReturn;

public class AuthBaseController {

	private String sessionKey;
	private String idSessionKey;
	private String nameSessionKey;

	private AuthBaseService authBaseService = null;
	
	public AuthBaseController( 
			String sessionKey, String idSessionKey, String nameSessionKey) {
		this.sessionKey = sessionKey;
		this.idSessionKey = idSessionKey;
		this.nameSessionKey = nameSessionKey;
	}

	public void setAuthBaseService(AuthBaseService authBaseService) {
		if(this.authBaseService == null){
			this.authBaseService = authBaseService;
		}
	}
	
	public UiReturn loginProcess(User userParams, HttpSession session) {

			// 如果已经有同一用户登录则跳过登录
			String usernameInSession = (String) session.getAttribute(nameSessionKey);
			if (userParams.getUsername().equals(usernameInSession)) {

				return UiReturn.ok(session.getAttribute(sessionKey), "已登录");

			} else {

				// 登录操作
				UiReturn uiReturn = authBaseService.login(userParams.getUsername(), userParams.getPassword());

				// 如果登录成功，加入session
				if (200 == uiReturn.getStatus()) {
					User user = (User) uiReturn.getData();
					session.setAttribute(sessionKey, user);
					session.setAttribute(idSessionKey, user.getId());
					session.setAttribute(nameSessionKey, user.getUsername());
				}

				return uiReturn;
			}
	}

	public UiReturn logoutProcess(HttpSession session) {
		session.invalidate();
		return UiReturn.ok(null, "注销成功");
	}

	public UiReturn registerProcess(User userParams, HttpSession session) {

		// 注册操作
		UiReturn uiReturn = authBaseService.register(userParams.getUsername(), userParams.getPassword());

		// 如果登录成功，加入session
		if (200 == uiReturn.getStatus()) {
			User user = (User) uiReturn.getData();
			session.setAttribute(sessionKey, user);
			session.setAttribute(idSessionKey, user.getId());
			session.setAttribute(nameSessionKey, user.getUsername());
		}
		
		return uiReturn;
	}
}
