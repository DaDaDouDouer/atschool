package com.gs.reusebook.dao;

import org.apache.ibatis.annotations.Param;

import com.gs.reusebook.bean.Shop;

public interface ShopDao {
	public int insert(Shop shop);
	public Shop selectBySellerId(String id);
	public void updateCarousel(@Param("idsStr") String idsStr, @Param("sellerId") String sellerId);
	public void updateRecommand(@Param("idsStr") String idsStr, @Param("sellerId") String sellerId);
}
