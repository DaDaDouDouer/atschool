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
import com.gs.reusebook.bean.Goods;
import com.gs.reusebook.bean.Seller;
import com.gs.reusebook.paramsbean.GoodsBookParam;
import com.gs.reusebook.paramsbean.GoodsSearchParams;
import com.gs.reusebook.service.GoodsService;
import com.gs.reusebook.util.UiReturn;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	/**
	 * 通过名字分页搜索商品
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn search(@RequestBody GoodsSearchParams params) {

		return goodsService.selectAndPaged
				(params.keyword, params.pageNo, params.limit, params.linkTable, params.fatchTypeIds(), params.conditions);
	}
	
	/**
	 * 分页获取卖家的所有商品
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/searchBySellerId", method = RequestMethod.POST)
	@NeedUserLogin(character = Seller.class)
	@ResponseBody
	public UiReturn searchBySellerId(@RequestBody GoodsSearchParams params, HttpSession session) {

		String sellerId = (String) session.getAttribute(SELLER_ID_SESSION_KEY);
		return goodsService.selectAndPagedBySellerId(params.keyword, sellerId, params.pageNo, params.limit);
	}
	
	
	/**
	 * 通过商品中的实际商品id获取实际商品对象
	 * @param goodsParams
	 * @return
	 */
	@RequestMapping(value = "/getRealGoods", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn getRealGoods	(@RequestBody Goods goodsParams) {

		// TODO 校验
		return goodsService.getRealGoods(goodsParams.getId());
	}
	
	/**
	 * 更新goods的描述字段
	 * @param goodsParams
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/updateDescription", method = RequestMethod.POST)
	@NeedUserLogin(character = Seller.class)
	@ResponseBody
	public UiReturn updateDescription(@RequestBody Goods goodsParams, HttpSession session){
		
		String sellerId = (String) session.getAttribute(SELLER_ID_SESSION_KEY);
		return goodsService.updateGoodsField
				(goodsParams.getId(), Goods.COLUMN_NAME_DESCRIPTION, goodsParams.getDescription(), sellerId);
	}
	
	/**
	 * 添加goods
	 * @param goodsParams
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@NeedUserLogin(character = Seller.class)
	@ResponseBody
	public UiReturn addGoods(@RequestBody Goods goodsParams, HttpSession session){
		
		String sellerId = (String) session.getAttribute(SELLER_ID_SESSION_KEY);
		String sellername = (String) session.getAttribute(SELLER_NAME_SESSION_KEY);
		return goodsService.addGoods(goodsParams, sellerId, sellername);
	}
	
	/**
	 * 添加goods
	 * @param goodsParams
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/addGoodsByIsbn", method = RequestMethod.POST)
	@NeedUserLogin(character = Seller.class)
	@ResponseBody
	public UiReturn addGoodsByIsbn(@RequestBody GoodsBookParam goodsBookParams, HttpSession session){
		String sellerId = (String) session.getAttribute(SELLER_ID_SESSION_KEY);
		String sellername = (String) session.getAttribute(SELLER_NAME_SESSION_KEY);
		return goodsService.addGoodsByIsbn(goodsBookParams.getIsbn(), goodsBookParams.getPrice(), goodsBookParams.getCount(), sellerId, sellername);
	}
	/**
	 * 删除goods
	 * @param goodsParams
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@NeedUserLogin(character = Seller.class)
	@ResponseBody
	public UiReturn deleteGoods(@RequestBody Goods goodsParams,HttpSession session){
		String sellerId = (String) session.getAttribute(SELLER_ID_SESSION_KEY);
		return goodsService.deleteGoods(goodsParams.getId(),sellerId);
	}
	
	/**
	 * 更新商品goods
	 * @param goodsParams
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@NeedUserLogin(character = Seller.class)
	@ResponseBody
	public UiReturn updateGoods(@RequestBody Goods goodsParams,HttpSession session){
		String sellerId = (String) session.getAttribute(SELLER_ID_SESSION_KEY);
		return goodsService.updateGoods(goodsParams.getId(), goodsParams.getPrice(), goodsParams.getCount(),sellerId);
	}
	
}
