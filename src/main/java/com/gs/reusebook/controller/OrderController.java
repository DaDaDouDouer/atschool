package com.gs.reusebook.controller;

import static com.gs.reusebook.util.ReusebookStatic.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.annotation.NeedUserLogin;
import com.gs.reusebook.paramsbean.OrderAddParams;
import com.gs.reusebook.service.OrderService;
import com.gs.reusebook.util.UiReturn;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	/**
	 * 获取当前卖家的全部订单
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/selectAllBySellerId", method = RequestMethod.GET)
	@ResponseBody
	public UiReturn selectAllBySellerId(HttpSession session){
		String sellerId= (String) session.getAttribute(SELLER_ID_SESSION_KEY);
		return orderService.selectAllBySellerId(sellerId);
	}

	/**
	 * 获取当前用户的全部订单
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/selectAllByUserId", method = RequestMethod.GET)
	@ResponseBody
	@NeedUserLogin
	public UiReturn selectAllByUserId(HttpSession session){
		String userId= (String) session.getAttribute(USER_ID_SESSION_KEY);
		return orderService.selectAllByUserId(userId);
	}

	/**
	 * 提交一个订单
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin
	public UiReturn add(@RequestBody OrderAddParams params, HttpSession session){
		String userId= (String) session.getAttribute(USER_ID_SESSION_KEY);
		return orderService.insertOrder(userId, params.goodsIdAndCount);
	}
}
