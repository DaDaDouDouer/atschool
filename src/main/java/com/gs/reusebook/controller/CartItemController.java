package com.gs.reusebook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.annotation.NeedUserLogin;
import com.gs.reusebook.bean.CartItem;
import com.gs.reusebook.service.CartItemService;
import com.gs.reusebook.util.UiReturn;
import static com.gs.reusebook.util.ReusebookStatic.*;

import java.util.List;

@Controller
@RequestMapping("/cartitem")
public class CartItemController {
	
	@Autowired
	private CartItemService cartItemService;
	
	/**
	 * 获取当前用户所有的购物车项
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	@ResponseBody
	@NeedUserLogin
	public UiReturn selectAll(HttpSession session) {
		String userId= (String) session.getAttribute(USER_ID_SESSION_KEY);
		return cartItemService.selectAll(userId);
	}

	/**
	 * 添加商品到当前用户的购物车
	 * @param cartItem
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin
	public UiReturn add(@RequestBody CartItem cartItem, HttpSession session) {
		String userId= (String) session.getAttribute(USER_ID_SESSION_KEY);
		return cartItemService.addToCart(userId, cartItem.getGoodsId(), cartItem.getGoodsCount());
	}

	/**
	 * 通过id删除一个购物车项
	 * @param cartItem
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/deleteById", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin
	public UiReturn deleteById(@RequestBody CartItem cartItem, HttpSession session) {
		String userId= (String) session.getAttribute(USER_ID_SESSION_KEY);
		return cartItemService.deleteCartItem(userId, cartItem.getId());
	}
	
	/**
	 * 更新某购物车项的商品数量
	 * @param cartItem
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/updateGoodsCount", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin
	public UiReturn updateGoodsCount(@RequestBody CartItem cartItem, HttpSession session) {
		String userId= (String) session.getAttribute(USER_ID_SESSION_KEY);
		return cartItemService.updateGoodsCount(userId, cartItem.getId(), cartItem.getGoodsCount()); 
	}
	

	/**
	 * 更新某购物车项的商品数量
	 * @param cartItem
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/updateAll", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin
	public UiReturn updateAll(@RequestBody List<CartItem> cartItems, HttpSession session) {
		String userId= (String) session.getAttribute(USER_ID_SESSION_KEY);
		return cartItemService.updateAll(userId, cartItems); 
	}
	
}
