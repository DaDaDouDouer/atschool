package com.gs.reusebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.bean.Book;
import com.gs.reusebook.service.BookService;
import com.gs.reusebook.util.UiReturn;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	/**
	 * 以键值的形式获取全部的分类
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn search(@RequestBody Book book) {
		
		// 参数校验
		return bookService.selectByBookCondition(book);
	}
}
