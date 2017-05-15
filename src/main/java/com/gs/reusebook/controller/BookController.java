package com.gs.reusebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.annotation.NeedUserLogin;
import com.gs.reusebook.bean.Book;
import com.gs.reusebook.bean.Seller;
import com.gs.reusebook.service.BookService;
import com.gs.reusebook.util.UiReturn;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	/**
	 * 添加book
	 * @param bookParams
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@NeedUserLogin(character = Seller.class)
	@ResponseBody
	public UiReturn addBook(@RequestBody Book bookParams){
		return bookService.addBook(bookParams);
	}
	
}
