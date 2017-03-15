package com.gs.reusebook.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.BookType;
import com.gs.reusebook.dao.BookTypeDao;
import com.gs.reusebook.util.UiReturn;

@Service
public class BookTypeService {
	
	@Autowired
	private BookTypeDao bookTypeDao;
	
	/**
	 * 以键值的形式获取全部的分类
	 * @return
	 */
	public UiReturn SelectAll(){
		List<BookType> allTypes = bookTypeDao.selectAll();
		Map<String, List<BookType>> totalType = new HashMap<String, List<BookType>>();
		for(BookType type : allTypes){
			String baseName = type.getBaseName();
			
			if(!totalType.containsKey(baseName)){
				totalType.put(baseName, new ArrayList<BookType>());
			}
			totalType.get(baseName).add(type);
			
		}
		return UiReturn.ok(totalType, "成功获取全部类型");
	}
	
	/**
	 * 通过id获取一个书籍分类
	 * @param typeId
	 * @return
	 */
	public UiReturn selectById(String typeId){
		return UiReturn.ok(bookTypeDao.selectById(typeId), "通过id查询书籍类型成功");
	}
	
	/**
	 * 插入一条书籍分类
	 * @param typeId
	 * @param name
	 * @param baseName
	 * @return
	 */
	public UiReturn insert(String typeId, String name, String baseName){
		BookType type = new BookType();
		type.setId(typeId);
		type.setName(name);
		type.setBaseName(baseName);
		bookTypeDao.insert(type);
		return UiReturn.ok("", "插入书籍类型成功");
	}
	
}
