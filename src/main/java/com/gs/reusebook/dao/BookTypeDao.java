package com.gs.reusebook.dao;

import com.gs.reusebook.bean.BookType;

public interface BookTypeDao {
	public BookType selectById(String typeId);
	public int insert(BookType type);
}
