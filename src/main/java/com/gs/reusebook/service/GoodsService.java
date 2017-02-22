package com.gs.reusebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Goods;
import com.gs.reusebook.bean.RealGoods;
import com.gs.reusebook.dao.BookDao;
import com.gs.reusebook.dao.DaoForRealGoods;
import com.gs.reusebook.dao.GoodsDao;
import com.gs.reusebook.util.DaoPool;

@Service
public class GoodsService implements ServiceWhichUseDaoPool{

	@Autowired
	private GoodsDao goodsDao;
	
	@Autowired
	private BookDao bookDao;

	/**
	 * 用于存储实际商品的dao
	 */
	private DaoPool daoPool = null;
	
	/**
	 * 构造时初始化dao池
	 */
	public GoodsService() {
		daoPool = new DaoPool();
		daoPool.initService(this);
	}
	
	/**
	 * 通过关键字分页搜索商品
	 * @param keyword
	 * @param pageNo
	 * @param limit
	 * @return
	 */
	public List<Goods> selectAndPagedByName(String keyword, int pageNo, int limit) {
		// TODO 参数校验

		int offset = (pageNo - 1) * limit;

		return goodsDao.selectAndPagedByName("%" + keyword + "%", offset, limit);
	}

	public RealGoods getRealGoods(String goodsId){
		// TODO 参数校验
		Goods goods = goodsDao.selectById(goodsId);
		// 为空校验
		DaoForRealGoods<?> realGoodsDao = daoPool.getDao(goods.getLinkTable());
		return realGoodsDao.selectById(goods.getRealGoodsId());
	}
	
	
	public BookDao getBookDao() {
		return bookDao;
	}
	
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
}
