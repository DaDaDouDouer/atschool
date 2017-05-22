package com.gs.reusebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gs.reusebook.annotation.NeedUserLogin;
import com.gs.reusebook.bean.Admin;
import com.gs.reusebook.bean.Order;
import com.gs.reusebook.paramsbean.CommonSearchParams;
import com.gs.reusebook.service.OrderService;
import com.gs.reusebook.util.UiReturn;

@Controller
@RequestMapping("/manager-order")
public class ManagerOrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@NeedUserLogin(character = Admin.class)
	@ResponseBody
	public UiReturn search(@RequestBody CommonSearchParams searchParams){
		return orderService.selectAndPagedById(searchParams.getKeyword(), searchParams.getPageNo(), searchParams.getLimit());
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@NeedUserLogin(character = Admin.class)
	@ResponseBody
	public UiReturn deleteOrder(@RequestBody Order orderParams){
		return orderService.deleteOrder(orderParams.getId());
	}
}
