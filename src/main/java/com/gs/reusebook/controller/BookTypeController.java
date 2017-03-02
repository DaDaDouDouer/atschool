package com.gs.reusebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.service.BookTypeService;
import com.gs.reusebook.util.UiReturn;

@Controller
@RequestMapping("/book/type")
public class BookTypeController {
	
	@Autowired
	private BookTypeService bookTypeService;
	
	/**
	 * 以键值的形式获取全部的分类
	 * @return
	 */
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	@ResponseBody
	public UiReturn selectAll() {
		return bookTypeService.SelectAll();
	}

}
