package com.gs.reusebook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn changePassword(@RequestBody ChangePasswordParams params, HttpSession session) {

		// TODO 校验
		
		String userId = (String) session.getAttribute(USER_ID_SESSION_KEY);
		UiReturn uiReturn = userService.changePassword(userId, params.oldPassword, params.newPassword);

		if (200 == uiReturn.getStatus()) {
			User user = (User) uiReturn.getData();
			session.setAttribute(USER_SESSION_KEY, user);
		}
		
		return uiReturn;
	}
	
	@RequestMapping(value = "/addAddress", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn addAddress(@RequestBody DeliveryAddress deliveryAddressParams, HttpSession session) {

		// TODO 校验
		
		String userId = (String) session.getAttribute(USER_ID_SESSION_KEY);
		return userService.addAddress(userId, deliveryAddressParams);
	}
	
	@RequestMapping(value = "/deleteAddress", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn deleteAddress(@RequestBody DeliveryAddress deliveryAddressParams, HttpSession session) {

		// TODO 校验

		String userId = (String) session.getAttribute(USER_ID_SESSION_KEY);
		return userService.deleteAddress(userId, deliveryAddressParams.getId());
	}
}
