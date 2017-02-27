package com.gs.reusebook.controller.base;

import javax.servlet.http.HttpSession;

import com.gs.reusebook.bean.base.AuthBaseBean;
import com.gs.reusebook.service.base.AuthBaseService;
import com.gs.reusebook.util.UiReturn;

public class AuthBaseController {

	private String sessionKey;
	private String idSessionKey;
	private String nameSessionKey;

	public AuthBaseController( 
			String sessionKey, String idSessionKey, String nameSessionKey) {
		this.sessionKey = sessionKey;
		this.idSessionKey = idSessionKey;
		this.nameSessionKey = nameSessionKey;
	}

	public UiReturn loginProcess(AuthBaseBean params, HttpSession session, AuthBaseService authBaseService) {

			// 如果已经有同一用户登录则跳过登录
			String usernameInSession = (String) session.getAttribute(nameSessionKey);
			if (params.getUsername().equals(usernameInSession)) {

				return UiReturn.ok(session.getAttribute(sessionKey), "已登录");

			} else {

				// 登录操作
				UiReturn uiReturn = authBaseService.login(params.getUsername(), params.getPassword());

				// 如果登录成功，加入session
				if (200 == uiReturn.getStatus()) {
					AuthBaseBean user = (AuthBaseBean) uiReturn.getData();
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

	public UiReturn registerProcess(AuthBaseBean params, HttpSession session, AuthBaseService authBaseService) {

		// 注册操作
		UiReturn uiReturn = authBaseService.register(params.getUsername(), params.getPassword());

		// 如果登录成功，加入session
		if (200 == uiReturn.getStatus()) {
			AuthBaseBean user = (AuthBaseBean) uiReturn.getData();
			session.setAttribute(sessionKey, user);
			session.setAttribute(idSessionKey, user.getId());
			session.setAttribute(nameSessionKey, user.getUsername());
		}
		
		return uiReturn;
	}
}
