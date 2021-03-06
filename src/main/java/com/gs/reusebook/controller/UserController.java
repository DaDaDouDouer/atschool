package com.gs.reusebook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.annotation.NeedUserLogin;
import com.gs.reusebook.bean.DeliveryAddress;
import com.gs.reusebook.bean.User;
import com.gs.reusebook.paramsbean.ChangePasswordParams;
import com.gs.reusebook.service.UserService;
import com.gs.reusebook.util.UiReturn;

import static com.gs.reusebook.util.ReusebookStatic.*;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 获取在商城中的用户信息
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/getUserInfoInMarketByUserId", method = RequestMethod.GET)
	@ResponseBody
	@NeedUserLogin
	public UiReturn getUserInfoInMarketByUserId(HttpSession session) {
		String userId = (String) session.getAttribute(USER_ID_SESSION_KEY);
		// TODO 为空校验
		return userService.getUserInfoInMarketByUserId(userId);
	}
	
	
	/**
	 * 修改密码
	 * @param params
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin
	public UiReturn updatePassword(@RequestBody ChangePasswordParams params, HttpSession session) {

		// TODO 校验
		
		String userId = (String) session.getAttribute(USER_ID_SESSION_KEY);
		UiReturn uiReturn = userService.changePassword(userId, params.oldPassword, params.newPassword);

		if (200 == uiReturn.getStatus()) {
			User user = (User) uiReturn.getData();
			session.setAttribute(USER_SESSION_KEY, user);
		}
		
		return uiReturn;
	}
	
	/**
	 * 添加收货地址
	 * @param deliveryAddressParams
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/addAddress", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin
	public UiReturn addAddress(@RequestBody DeliveryAddress deliveryAddressParams, HttpSession session) {

		// TODO 校验
		
		String userId = (String) session.getAttribute(USER_ID_SESSION_KEY);
		return userService.addAddress(userId, deliveryAddressParams);
	}
	
	/**
	 * 删除收货地址
	 * @param deliveryAddressParams
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/deleteAddress", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin
	public UiReturn deleteAddress(@RequestBody DeliveryAddress deliveryAddressParams, HttpSession session) {

		// TODO 校验

		String userId = (String) session.getAttribute(USER_ID_SESSION_KEY);
		return userService.deleteAddress(userId, deliveryAddressParams.getId());
	}
}
