package com.gs.reusebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Goods;
import com.gs.reusebook.dao.BookDao;
import com.gs.reusebook.dao.DaoForRealGoods;
import com.gs.reusebook.dao.GoodsDao;
import com.gs.reusebook.util.DaoPool;
import com.gs.reusebook.util.UiReturn;

@Service
public class GoodsService implements ServiceWhichUseDaoPool{

	@Autowired
	private GoodsDao goodsDao;
	
	@Autowired
	private BookDao bookDao;

	/**
	 * 用于存储实际商品dao的dao池
	 */
	private DaoPool daoPool = null;
	
	/**
	 * 构造service时时初始化dao池
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
	public UiReturn selectAndPagedByName(String keyword, int pageNo, int limit) {
		// TODO 参数校验修正

		int offset = (pageNo - 1) * limit;

		return UiReturn.ok(goodsDao.selectAndPagedByName("%" + keyword + "%", offset, limit), "搜索成功");
	}

	/**
	 * 通过goods中的实际商品id和表名获取实际商品对象
	 * @param goodsId 商品id，不是实际商品id
	 * @return
	 */
	public UiReturn getRealGoods(String goodsId){
		// TODO 参数校验
		Goods goods = goodsDao.selectById(goodsId);
		
		// TODO 为空校验
		DaoForRealGoods<?> realGoodsDao = daoPool.getDao(goods.getLinkTable());
		
		return UiReturn.ok(realGoodsDao.selectById(goods.getRealGoodsId()), "获取成功");
	}
	
	
	public BookDao getBookDao() {
		return bookDao;
	}
	
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
}
