package com.gs.reusebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.annotation.NeedUserLogin;
import com.gs.reusebook.bean.Admin;
import com.gs.reusebook.bean.Seller;
import com.gs.reusebook.bean.base.AuthBaseBean;
import com.gs.reusebook.controller.base.AuthSellerBaseController;
import com.gs.reusebook.paramsbean.CommonSearchParams;
import com.gs.reusebook.service.AuthSellerService;
import com.gs.reusebook.service.SellerService;
import com.gs.reusebook.util.UiReturn;

@Controller
@RequestMapping("/manager-seller")
public class ManagerSellerController extends AuthSellerBaseController{
	
	@Autowired
	private AuthSellerService authSellerService;
	@Autowired
	private SellerService sellerService;
	/**
	 * 显示后台卖家的信息
	 * @param searchParams
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@NeedUserLogin(character = Admin.class)
	@ResponseBody
	public UiReturn search(@RequestBody CommonSearchParams searchParams){
		return sellerService.searchAndPagedByName(searchParams.getKeyword(), searchParams.getPageNo(), searchParams.getLimit());
	}
	/**
	 * 后台添加卖家
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@NeedUserLogin(character = Admin.class)
	@ResponseBody
	public UiReturn addSeller(@RequestBody AuthBaseBean params){
		return authSellerService.register(params.getUsername(), params.getPassword(), params.getMail());
	}
	/**
	 * 后台修改卖家的密码
	 * @param sellerParams
	 * @return
	 */
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	@NeedUserLogin(character = Admin.class)
	@ResponseBody
	public UiReturn updatePassword(@RequestBody Seller sellerParams){
		return sellerService.updatePassword(sellerParams.getId(), sellerParams.getPassword());
	}
	/**
	 * 后台删除卖家
	 * @param sellerParams
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@NeedUserLogin(character = Admin.class)
	@ResponseBody
	public UiReturn deleteSeller(@RequestBody Seller sellerParams){
		return sellerService.deleteSeller(sellerParams.getId());
	}

}
