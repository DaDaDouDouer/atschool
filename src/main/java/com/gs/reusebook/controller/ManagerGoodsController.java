package com.gs.reusebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gs.reusebook.annotation.NeedUserLogin;
import com.gs.reusebook.bean.Admin;
import com.gs.reusebook.bean.Goods;
import com.gs.reusebook.paramsbean.GoodsSearchParams;
import com.gs.reusebook.service.GoodsService;
import com.gs.reusebook.util.UiReturn;

@Controller
@RequestMapping("/manager-goods")
public class ManagerGoodsController {
	@Autowired
	private GoodsService goodsService;
	
	/**
	 * 通过名字分页搜索商品
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@NeedUserLogin(character = Admin.class)
	@ResponseBody
	public UiReturn search	(@RequestBody GoodsSearchParams params) {

		return goodsService.selectAndPaged
				(params.keyword, params.pageNo, params.limit, params.linkTable, params.fatchTypeIds(), params.conditions);
	}
	
	/**
	 * 根据商品Id删除商品
	 * @param goodsParams
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@NeedUserLogin(character = Admin.class)
	@ResponseBody
	public UiReturn deleteGoods(@RequestBody Goods goodsParams){
		return goodsService.deleteGoods(goodsParams.getId());
	}
}
