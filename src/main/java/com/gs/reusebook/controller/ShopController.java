package com.gs.reusebook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.annotation.NeedUserLogin;
import com.gs.reusebook.bean.Goods;
import com.gs.reusebook.bean.Seller;
import com.gs.reusebook.bean.Shop;
import com.gs.reusebook.service.ShopService;
import com.gs.reusebook.util.UiReturn;
import static com.gs.reusebook.util.ReusebookStatic.*;

import java.util.List;
import java.util.Map;

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
	public UiReturn add(@RequestBody Shop shopParams, HttpSession session) {
		
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
	public UiReturn updateCarousel(@RequestBody List<Map<String,String>> urlAndDescs, HttpSession session) {
		
		String sellerId = (String) session.getAttribute(SELLER_ID_SESSION_KEY);
		return shopService.updateCarousel(urlAndDescs, sellerId);
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
	 * 添加一个推荐商品
	 * @param goodsParam
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/addRecommand", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin(character = Seller.class)
	public UiReturn addRecommand(@RequestBody Goods goodsParam, HttpSession session) {
		
		String sellerId = (String) session.getAttribute(SELLER_ID_SESSION_KEY);
		return shopService.addRecommand(goodsParam.getId(), sellerId);
		
	}
	
	/**
	 * 去除一个推荐商品
	 * @param goodsParam
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/removeRecommand", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin(character = Seller.class)
	public UiReturn removeRecommand(@RequestBody Goods goodsParam, HttpSession session) {
		
		String sellerId = (String) session.getAttribute(SELLER_ID_SESSION_KEY);
		return shopService.removeRecommand(goodsParam.getId(), sellerId);
		
	}

	/**
	 * 添加一个轮播图和描述
	 * @param goodsParam
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/addCarousel", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin(character = Seller.class)
	public UiReturn addCarousel(@RequestBody Map<String,String> urlAndDesc, HttpSession session) {
		
		String sellerId = (String) session.getAttribute(SELLER_ID_SESSION_KEY);
		return shopService.addCarousel(urlAndDesc, sellerId);
		
	}
	
	/**
	 * 去除一个轮播图和描述
	 * @param goodsParam
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/removeCarousel", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin(character = Seller.class)
	public UiReturn removeCarousel(@RequestBody Goods goodsParam, HttpSession session) {
		
		String sellerId = (String) session.getAttribute(SELLER_ID_SESSION_KEY);
		return shopService.removeCarousel(goodsParam.getImgUrl(), sellerId);
		
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
	public UiReturn getBySellerId(@RequestBody Shop shopParams) {
		
		return shopService.getBySellerId(shopParams.getSellerId());
		
	}
	
}
