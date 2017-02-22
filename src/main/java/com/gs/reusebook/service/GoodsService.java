package com.gs.reusebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Goods;
import com.gs.reusebook.dao.GoodsDao;

@Service
public class GoodsService {

	@Autowired
	private GoodsDao goodsDao;

	public List<Goods> selectAndPagedByName(String keyword, int pageNo, int limit) {
		// TODO 参数校验

		int offset = (pageNo - 1) * limit;

		return goodsDao.selectAndPagedByName("%" + keyword + "%", offset, limit);
	}

}
