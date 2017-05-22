package com.gs.reusebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.annotation.NeedUserLogin;
import com.gs.reusebook.bean.Admin;
import com.gs.reusebook.bean.Shop;
import com.gs.reusebook.paramsbean.CommonSearchParams;
import com.gs.reusebook.service.ShopService;
import com.gs.reusebook.util.UiReturn;

@Controller
@RequestMapping("/manager-shop")
public class ManagerShopController {
	@Autowired
	private ShopService shopService;
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	//@NeedUserLogin(character = Admin.class)
	@ResponseBody
	public UiReturn search(@RequestBody CommonSearchParams searchParams){
		return shopService.selectAndPagedByName(searchParams.getKeyword(), searchParams.getPageNo(), searchParams.getLimit());
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	//@NeedUserLogin(character = Admin.class)
	@ResponseBody
	public UiReturn updateShopName(@RequestBody Shop shopParams){
		return shopService.updateShopName(shopParams.getName(), shopParams.getId());
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	//@NeedUserLogin(character = Admin.class)
	@ResponseBody
	public UiReturn deleteShop(@RequestBody Shop shopParams){
		return shopService.deleteShop(shopParams.getId());
	}
}
