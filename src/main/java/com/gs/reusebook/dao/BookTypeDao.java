package com.gs.reusebook.dao;

import java.util.List;

import com.gs.reusebook.bean.BookType;

public interface BookTypeDao {
	public List<BookType> selectAll();
	public BookType selectById(String typeId);
	public int insert(BookType type);
}
