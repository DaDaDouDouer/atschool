package com.gs.reusebook.controller;

import static com.gs.reusebook.util.GlobalStatus.REQ_ERROR_400;
import static com.gs.reusebook.util.GlobalStatus.SUCCESS_200;

import javax.servlet.http.HttpSession;

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
	
	/**
	 * 登录操作   
	 * @param username 用户名
	 * @param password 密码
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn login(@RequestBody User userParams, HttpSession session) {
		
		UiReturn result = null;
		
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
	 * 注销操作
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public UiReturn logout(HttpSession session) {
		return logoutProcess(session);
	}
}
