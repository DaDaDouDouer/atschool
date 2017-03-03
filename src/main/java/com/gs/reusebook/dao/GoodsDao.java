package com.gs.reusebook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gs.reusebook.bean.Goods;


public interface GoodsDao {
	public List<Goods> selectAndPagedByName
	(@Param("name") String name, @Param("offset") int offset, @Param("limit") int limit);
	
	public Integer selectCount(String name);
	
	public Goods selectById(String id);
	public List<Goods> selectByIds(List<String> ids);
	public void updateCount(@Param("id") String id, @Param("count") int count);
}
