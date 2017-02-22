package com.gs.reusebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.paramsbean.GoodsSearchParams;
import com.gs.reusebook.service.GoodsService;
import com.gs.reusebook.util.UiReturn;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn search	(@RequestBody GoodsSearchParams params) {

		// TODO 校验
		
		return UiReturn.ok(goodsService.selectAndPagedByName
				(params.keyword, params.pageNo, params.limit), "搜索成功");
	}
}
