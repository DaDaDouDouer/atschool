package com.gs.reusebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.annotation.NeedUserLogin;
import com.gs.reusebook.bean.Admin;
import com.gs.reusebook.bean.User;
import com.gs.reusebook.paramsbean.CommonSearchParams;
import com.gs.reusebook.service.UserService;
import com.gs.reusebook.util.UiReturn;

@Controller
@RequestMapping("/manager-user")
public class ManagerUserController {
	@Autowired
	private UserService userService;
	/**
	 * 后台搜索用户
	 * @param searchParams
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@NeedUserLogin(character = Admin.class)
	@ResponseBody
	public UiReturn search(@RequestBody CommonSearchParams searchParams){
		return userService.selectAndPagedByName(searchParams.getKeyword(), searchParams.getPageNo(), searchParams.getLimit());
	}
	/**
	 * 后台管理员删除用户
	 * @param userParams
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@NeedUserLogin(character = Admin.class)
	@ResponseBody
	public UiReturn deleteUser(@RequestBody User userParams){
		return userService.deleteUser(userParams.getId());
	}
}
