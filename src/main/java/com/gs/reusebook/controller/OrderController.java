package com.gs.reusebook.controller;

import static com.gs.reusebook.util.ReusebookStatic.ORDER_STATUS_END;
import static com.gs.reusebook.util.ReusebookStatic.ORDER_STATUS_PAYED;
import static com.gs.reusebook.util.ReusebookStatic.ORDER_STATUS_PAYED_OK;
import static com.gs.reusebook.util.ReusebookStatic.ORDER_STATUS_SENDED;
import static com.gs.reusebook.util.ReusebookStatic.SELLER_ID_SESSION_KEY;
import static com.gs.reusebook.util.ReusebookStatic.USER_ID_SESSION_KEY;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.annotation.NeedUserLogin;
import com.gs.reusebook.bean.OrderItem;
import com.gs.reusebook.bean.Seller;
import com.gs.reusebook.bean.User;
import com.gs.reusebook.paramsbean.OrderAddParams;
import com.gs.reusebook.paramsbean.SearchParams;
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
	@RequestMapping(value = "/selectAllBySellerId", method = RequestMethod.POST)
	@NeedUserLogin(character = Seller.class)
	@ResponseBody
	public UiReturn selectAllBySellerId(@RequestBody SearchParams params, HttpSession session){
		String sellerId= (String) session.getAttribute(SELLER_ID_SESSION_KEY);
		return orderService.selectAllBySellerId(params.keyword, sellerId, params.pageNo, params.limit);
	}

	/**
	 * 获取当前用户的全部订单
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/selectAllByUserId", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin
	public UiReturn selectAllByUserId(@RequestBody SearchParams params,HttpSession session){
		String userId= (String) session.getAttribute(USER_ID_SESSION_KEY);
		return orderService.selectAllByUserId(userId, params.pageNo, params.limit);
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
		String userId = (String) session.getAttribute(USER_ID_SESSION_KEY);
		return orderService.insertOrder(userId, params.goodsIdAndCount, params.address);
	}
	
	//---------------------------------以下是修改订单状态接口---------------------------------
	
	/**
	 * 买家确认已支付，需要用户登录
	 * @param orderItemParams
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/userPayed", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin
	public UiReturn add(@RequestBody OrderItem orderItemParams, HttpSession session){
		String userId= (String) session.getAttribute(USER_ID_SESSION_KEY);
		return orderService.updateStatus(orderItemParams.getId(), ORDER_STATUS_PAYED, true, userId);
	}

	/**
	 * 卖家确认买家已支付，需要卖家登陆
	 * @param orderItemParams
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/userPayedOk", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin(character = Seller.class)
	public UiReturn userPayedOk(@RequestBody OrderItem orderItemParams, HttpSession session){
		String sellerId= (String) session.getAttribute(SELLER_ID_SESSION_KEY);
		return orderService.updateStatus(orderItemParams.getId(), ORDER_STATUS_PAYED_OK, false, sellerId);
	}

	/**
	 * 卖家确认买家已支付，需要卖家登陆
	 * @param orderItemParams
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/payAll", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin(character = User.class)
	public UiReturn payAll(@RequestBody List<String> orderItemids, HttpSession session){
		String userId = (String) session.getAttribute(USER_ID_SESSION_KEY);
		return orderService.payAll(orderItemids, userId);
	}

	/**
	 * 卖家确认已发货，需要卖家登陆
	 * @param orderItemParams
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/sellerSended", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin(character = Seller.class)
	public UiReturn sellerSended(@RequestBody OrderItem orderItemParams, HttpSession session){
		String sellerId= (String) session.getAttribute(SELLER_ID_SESSION_KEY);
		return orderService.updateStatus(orderItemParams.getId(), ORDER_STATUS_SENDED, false, sellerId);
	}

	/**
	 * 买家确认已收货，需要买家登陆
	 * @param orderItemParams
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/userReceived", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin
	public UiReturn userReceived(@RequestBody OrderItem orderItemParams, HttpSession session){
		String userId= (String) session.getAttribute(USER_ID_SESSION_KEY);
		return orderService.updateStatus(orderItemParams.getId(), ORDER_STATUS_END, true, userId);
	}
}
