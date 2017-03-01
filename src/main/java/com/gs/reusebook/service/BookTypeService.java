package com.gs.reusebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.BookType;
import com.gs.reusebook.dao.BookTypeDao;
import com.gs.reusebook.util.UiReturn;

@Service
public class BookTypeService {
	
	@Autowired
	private BookTypeDao bookTypeDao;
	
	public UiReturn selectById(String typeId){
		return UiReturn.ok(bookTypeDao.selectById(typeId), "通过id查询书籍类型成功");
	}
	
	public UiReturn insert(String typeId, String name){
		BookType type = new BookType();
		type.setId(typeId);
		type.setName(name);
		bookTypeDao.insert(type);
		return UiReturn.ok("", "插入书籍类型成功");
	}
	
	
	
}
