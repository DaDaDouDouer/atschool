package com.gs.reusebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Book;
import com.gs.reusebook.dao.BookDao;
import com.gs.reusebook.util.UiReturn;
import static com.gs.reusebook.util.ReusebookStatic.*;

@Service
public class BookService {
	
	@Autowired
	private BookDao bookDao;
	
	/**
	 * 根据搜索条件搜索书
	 * @param book
	 * @return
	 */
	public UiReturn selectByBookCondition(Book book){
		// 如果没有给出搜索的书籍类型则默认为默认类型
		List<String> typeIds = book.fatchTypeIds();
		if(typeIds.isEmpty()){
			typeIds.add(DEFAULT_BOOK_TYPE_ID);
		}
		return UiReturn.ok(bookDao.selectByBookCondition(book, typeIds), "按条件查询书成功");
	}
}
