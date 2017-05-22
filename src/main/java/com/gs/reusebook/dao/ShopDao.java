package com.gs.reusebook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gs.reusebook.bean.Shop;

public interface ShopDao {
	public int insert(Shop shop);
	public Shop selectBySellerId(String id);
	public Shop selectByName(String name);
	public List<Shop> selectAndPagedByName(@Param("name")String username,@Param("offset") int offset, @Param("limit") int limit);
	public Integer selectCountByName(String name);
	public void updateName(@Param("idsStr") String idsStr, @Param("id") String id);
	public void updateCarousel(@Param("idsStr") String idsStr, @Param("sellerId") String sellerId);
	public void updateRecommand(@Param("idsStr") String idsStr, @Param("sellerId") String sellerId);
	public void deleteShop(String id);
	
}
