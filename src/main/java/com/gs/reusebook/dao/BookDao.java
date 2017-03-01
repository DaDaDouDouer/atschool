package com.gs.reusebook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gs.reusebook.bean.Book;
import com.gs.reusebook.dao.base.RealGoodsBaseDao;

public interface BookDao extends RealGoodsBaseDao<Book>{
	
	/**
	 * 把book的属性作为条件查询book
	 * @param bookCondition
	 * @return
	 */
	public List<Book> selectByBookCondition
		(@Param("book") Book bookCondition, @Param("types") List<String> types);
}
