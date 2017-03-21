package com.gs.reusebook.dao.base;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gs.reusebook.bean.Goods;
import com.gs.reusebook.bean.base.RealGoods;

public interface RealGoodsBaseDao<T extends RealGoods> {
	
	/**
	 * 通过实际商品id获取实际商品对象
	 * @param id
	 * @return
	 */
	public T selectById(String id); 
	
	/**
	 * 通过关键字、分页参数、类型和其他筛选参数查询商品。
	 * @param name
	 * @param offset
	 * @param limit
	 * @param typIds
	 * @param conditions
	 * @return
	 */
	public List<Goods> selectAndPaged
		(@Param("name") String name, @Param("offset") int offset, @Param("limit") int limit, @Param("typeIds") List<String> typIds, @Param("conditions") Map<String, Object> conditions);
	
	public int selectCount
		(@Param("name") String name, @Param("typeIds") List<String> typIds ,@Param("conditions") Map<String, Object> conditions);

}
