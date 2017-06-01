package com.gs.reusebook.controller;

import static com.gs.reusebook.util.GlobalStatus.*;
import static com.gs.reusebook.util.ReusebookStatic.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.bean.Admin;
import com.gs.reusebook.bean.Seller;
import com.gs.reusebook.bean.User;
import com.gs.reusebook.controller.base.AuthUserBaseController;
import com.gs.reusebook.paramsbean.AuthParams;
import com.gs.reusebook.service.AuthService;
import com.gs.reusebook.util.UiReturn;

/**
 * 所有用户登录身份验证
 * 
 * @author IceAsh
 *
 */
@Controller
@RequestMapping("/auth")
public class AuthController extends AuthUserBaseController{

	@Autowired
	AuthUserController authUserController;
	@Autowired
	AuthSellerController authSellerController;
	@Autowired
	AuthAdminController authAdminController;
	@Autowired
	AuthService authService;
	
	/**
	 * 登录操作   
	 * @param username 用户名
	 * @param password 密码
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn login(@RequestBody AuthParams userParams, HttpSession session) {
		
		UiReturn result = null;
		
		// 验证码验证，不考虑大小写
		String checkCodeInSession = (String) session.getAttribute(CHECK_CODE_SESSION_KEY);
		if(!(StringUtils.isNotEmpty(checkCodeInSession) && checkCodeInSession.equalsIgnoreCase(userParams.checkCode))){
			return UiReturn.notOk("", "验证码错误", NOT_VALIDATE_401);
		}
		// 使用过后销毁验证码
		session.setAttribute(CHECK_CODE_SESSION_KEY, null);
		
		// 只要有一个成功了则说明登陆成功
		result = authUserController.login(userParams, session);
		if(result.getStatus() == SUCCESS_200){
			result.setOther(User.class.getSimpleName());
			return result;
		}
		result = authSellerController.login(userParams, session);
		if(result.getStatus() == SUCCESS_200){
			result.setOther(Seller.class.getSimpleName());
			return result;
		}
		result = authAdminController.login(userParams, session);
		if(result.getStatus() == SUCCESS_200){
			result.setOther(Admin.class.getSimpleName());
			return result;
		}
		
		// 如果一个都没有成功则登陆失败
		return UiReturn.notOk(null, "登陆失败", REQ_ERROR_400);
		
	}
	
	/**
	 * 获取登陆验证码
	 */
	@RequestMapping(value = "/getCheckCode", method = RequestMethod.GET)
	@ResponseBody
	public void getCheckCode(HttpSession session, HttpServletResponse resp) {
		
		// TODO 限制访问频率
		
		session.setAttribute(CHECK_CODE_SESSION_KEY, authService.getCheckCode(resp));
		
	}
	
	/**
	 * 找回密码   
	 * @param mail 邮箱
	 */
	@RequestMapping(value = "/findPassword", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn findPassword(@RequestBody AuthParams userParams) {
		return authService.findPassword(userParams.getUsername());
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
