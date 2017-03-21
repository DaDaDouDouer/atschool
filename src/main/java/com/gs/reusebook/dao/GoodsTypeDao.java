package com.gs.reusebook.dao;

import java.util.List;

import com.gs.reusebook.bean.GoodsType;

public interface GoodsTypeDao {
	public List<GoodsType> selectAll();
	public List<GoodsType> selectByLinkTable(String linkTable);
	public GoodsType selectById(String typeId);
	public int insert(GoodsType type);
}
