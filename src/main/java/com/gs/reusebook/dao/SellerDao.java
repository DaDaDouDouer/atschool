package com.gs.reusebook.dao;

import java.util.List;

import com.gs.reusebook.bean.Seller;
import org.apache.ibatis.annotations.Param;

import com.gs.reusebook.bean.User;
import com.gs.reusebook.dao.base.AuthBaseDao;

/**
 * 
 * @author IceAsh
 *
 */
public interface SellerDao extends AuthBaseDao<User>{
	public List<User> selectAndPagedByName(@Param("username")String username,@Param("offset") int offset, @Param("limit") int limit);
	public Integer selectCountByName(String username);
	public List<User> selectByName(String username);
	public Seller selectByGoodsId(String goodsId);
	public int insert(User user);
	public void updatePassword(@Param("id") String id, @Param("password") String password);
	public void deleteSeller(String id);
}
