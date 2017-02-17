package com.gs.reusebook.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.bean.User;
import com.gs.reusebook.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ResponseBody
	public User index(){
		System.out.println("---------------into index---------------");
		
		User user = new User();
		int i = (int) (1000 * Math.random());
		user.setId(i);
		user.setUsername("erwtwret" + i);
		user.setPassword("3431" + i);
		
		userService.insertUser(user);
		
		System.out.println("---------------out index---------------");
		
		return user;
	}

	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	@ResponseBody
	public List<User> selectAll(){
		return userService.selectAll();
	}

	@RequestMapping(value = "/selectByName", method = RequestMethod.GET)
	@ResponseBody
	public List<User> selectByName(){
		return userService.selectByName("5");
	}
	
	/**
	 * get url后面跟的参数必须加注解@RequestParam
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteById", method = RequestMethod.GET)
	@ResponseBody
	public String deleteById(@RequestParam Integer id){
		userService.deleteById(id);
		return "delete success";
	}
	
	/**
	 * post参数的话不用加注解直接写参数，前端传来的必须是x-www-form-urlencoded的参数
	 * @param id
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/updateUsername", method = RequestMethod.POST)
	@ResponseBody
	public String updateUsername(int id, String username){
		userService.updateUsername(username, id);
		return "update success";
	}
	

	/**
	 * post参数也可以像这样写在bean里，不过前端传来的还必须是x-www-form-urlencoded的参数
	 * 而且前端参数格式也可以写成user.username,user.id这种形式（为了有多个bean的准备）
	 * @param id
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/updateUsernameBean", method = RequestMethod.POST)
	@ResponseBody
	public String updateUsernameBean(User user){
		userService.updateUsername(user.getUsername(), user.getId());
		return "update success";
	}
	
	/**
	 * session就直接写在参数里
	 * @param token
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/sessionTest", method = RequestMethod.GET)
	@ResponseBody
	public String sessionTest(@RequestParam String token, HttpSession session){
		String oldToken = (String) session.getAttribute(	"token");
		session.setAttribute("token", token);
		
		return "" + oldToken + "," + token;
	}
	
	
}
