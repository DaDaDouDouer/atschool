package com.gs.reusebook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gs.reusebook.bean.Order;

public interface OrderDao {
	public List<Order> selectAndPagedById(@Param("id")String id,@Param("offset") int offset, @Param("limit") int limit);
	/**
	 * 根据id模糊查询出数量，为selectAndPagedById服务
	 * @param id
	 * @return
	 */
	public Integer selectCountById(String id);
	
	public List<Order> selectAllBySellerId(@Param("name") String name, @Param("sellerId") String sellerId, @Param("offset") int offset, @Param("limit") int limit);
	public Integer selectCountBySellerId(@Param("name") String name, @Param("sellerId") String sellerId);
	
	public List<Order> selectAllByUserId(@Param("userId") String userId, @Param("offset") int offset, @Param("limit") int limit);
	public Integer selectCountByUserId(String userId);
	
	public List<Order> selectByUserIdAndGoodsId(@Param("userId") String userId, @Param("goodsId") String goodsId);
	
	public Order selectById(String id);
	
	public Order selectByItemId(String itemId);
	
	public void updateStatus(@Param("status") int status, @Param("id") String id);
	
	public int insertOrder(Order order);
	
	public void deleteOrder(String id);
}
