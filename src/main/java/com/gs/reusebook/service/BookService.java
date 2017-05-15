package com.gs.reusebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Book;
import com.gs.reusebook.bean.Goods;
import com.gs.reusebook.dao.BookDao;
import com.gs.reusebook.dao.GoodsDao;
import com.gs.reusebook.util.UiReturn;
import static com.gs.reusebook.util.ReusebookStatic.*;

import java.util.UUID;

@Service
public class BookService {
	
	@Autowired
	private BookDao bookDao;
	
	/**
	 * 添加书籍
	 * @param book
	 * @return
	 */
	public UiReturn addBook(Book book){
		book.setId(UUID.randomUUID().toString());
		Book sameBook = bookDao.selectByIsbn(book.getIsbn());
		
		if(sameBook == null || sameBook.getId() == null || sameBook.getId().isEmpty())
			bookDao.insertBook(book);
		else
			book.setId(sameBook.getId());
		
		return UiReturn.ok(book, "添加成功");
	}
	
}
