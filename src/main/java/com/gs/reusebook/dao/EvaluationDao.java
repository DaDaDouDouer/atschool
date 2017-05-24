package com.gs.reusebook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gs.reusebook.bean.Evaluation;

public interface EvaluationDao {
	/**
	 * 获取某个商品的全部评论
	 * @param goodsId
	 * @return
	 */
	public List<Evaluation> selectAll(String goodsId);
	
	public List<Evaluation> selectAllBySellerId(@Param("sellerId") String sellerId, @Param("offset") int offset, @Param("limit") int limit);
	public Integer selectCountBySellerId(String sellerId);
	
	public int insertEvaluation(Evaluation evaluation);
	public List<Evaluation> selectByUserIdAndGoodsId
		(@Param("userId") String userId, @Param("goodsId") String goodsId);
}
