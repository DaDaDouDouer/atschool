package com.gs.reusebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.bean.GoodsType;
import com.gs.reusebook.service.GoodsTypeService;
import com.gs.reusebook.util.UiReturn;

@Controller
@RequestMapping("/goods/type")
public class GoodsTypeController {
	
	@Autowired
	private GoodsTypeService goodsTypeService;
	
	/**
	 * 以键值的形式获取全部的分类
	 * @return
	 */
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	@ResponseBody
	public UiReturn selectAll() {
		return goodsTypeService.selectAll();
	}

	/**
	 * 通过表名获取这种商品下的全部分类
	 * @param goodsTypeParams
	 * @return
	 */
	@RequestMapping(value = "/selectByLinkTable", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn selectByLinkTable(@RequestBody GoodsType goodsTypeParams) {
		return goodsTypeService.selectByLinkTable(goodsTypeParams.getLinkTable());
	}
}
