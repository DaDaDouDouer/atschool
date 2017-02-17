package com.gs.reusebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录注册等身份验证
 * @author IceAsh
 *
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(int id, String username){
		
		
		
		return "update success";
	}
}
