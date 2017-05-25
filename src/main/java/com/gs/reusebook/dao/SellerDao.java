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
public interface SellerDao extends AuthBaseDao<Seller>{
	public List<Seller> selectAndPagedByName(@Param("username")String username,@Param("offset") int offset, @Param("limit") int limit);
	public Integer selectCountByName(String username);
	public List<Seller> selectByName(String username);
	public Seller selectByGoodsId(String goodsId);
	public Seller selectById(String id);
	public int insert(User user);
	public void updatePassword(@Param("id") String id, @Param("password") String password);
	public void deleteSeller(String id);
}
