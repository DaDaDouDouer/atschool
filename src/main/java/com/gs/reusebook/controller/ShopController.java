package com.gs.reusebook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.annotation.NeedUserLogin;
import com.gs.reusebook.bean.Seller;
import com.gs.reusebook.bean.Shop;
import com.gs.reusebook.service.ShopService;
import com.gs.reusebook.util.UiReturn;
import static com.gs.reusebook.util.ReusebookStatic.*;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	/**
	 * 创建店铺
	 * @param params
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin(character = Seller.class)
	public UiReturn updatePassword(@RequestBody Shop shopParams, HttpSession session) {
		
		String sellerId = (String) session.getAttribute(SELLER_ID_SESSION_KEY);
		return shopService.add(shopParams.getName(), sellerId);
		
	}


	/**
	 * 更新轮播商品的good id目录
	 * @param goodsIds
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/updateCarousel", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin(character = Seller.class)
	public UiReturn updateCarousel(@RequestBody List<String> goodsIds, HttpSession session) {
		
		String sellerId = (String) session.getAttribute(SELLER_ID_SESSION_KEY);
		return shopService.updateGoodIds(Shop.CAROUSEL_NAME, goodsIds, sellerId);
		
	}
	
	/**
	 * 更新推荐商品的good id目录
	 * @param goodsIds
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/updateCommand", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin(character = Seller.class)
	public UiReturn updateCommand(@RequestBody List<String> goodsIds, HttpSession session) {
		
		String sellerId = (String) session.getAttribute(SELLER_ID_SESSION_KEY);
		return shopService.updateGoodIds(Shop.RECOMMAND_NAME, goodsIds, sellerId);
		
	}
	

	/**
	 * 卖家获取自己全部的商铺信息
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/getOwn", method = RequestMethod.GET)
	@ResponseBody
	@NeedUserLogin(character = Seller.class)
	public UiReturn getOwn(HttpSession session) {
		
		String sellerId = (String) session.getAttribute(SELLER_ID_SESSION_KEY);
		return shopService.getBySellerId(sellerId);
		
	}
	
	/**
	 * 买家通过卖家id获取全部的商铺信息
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/getBySellerId", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn getBySellerId(@RequestBody Shop shopParams, HttpSession session) {
		
		return shopService.getBySellerId(shopParams.getSellerId());
		
	}
	
}
