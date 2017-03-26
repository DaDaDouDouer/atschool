package com.gs.reusebook.connect;

import com.gs.reusebook.bean.Book;
/**
 * 豆瓣网Connect
 * @author HughDing
 *
 */
public class DoubanConnect {
	/**
	 * 从豆瓣网接口获取书籍信息
	 * @param isbn
	 * @return
	 */
	public Book getBook(String isbn){
		Book book = new Book();
		return book;
	}
}
