package com.gs.reusebook.dao;

import com.gs.reusebook.bean.Book;
import com.gs.reusebook.dao.base.RealGoodsBaseDao;

public interface BookDao extends RealGoodsBaseDao<Book>{
	public Book selectByIsbn(String isbn);
	public int insertBook(Book book);
}
