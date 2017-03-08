package com.gs.reusebook.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Goods;
import com.gs.reusebook.dao.BookDao;
import com.gs.reusebook.dao.GoodsDao;
import com.gs.reusebook.dao.base.RealGoodsBaseDao;
import com.gs.reusebook.util.DaoPool;
import com.gs.reusebook.util.UiReturn;
import static com.gs.reusebook.util.ReusebookStatic.*;

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
	public UiReturn selectAndPagedByName(String keyword, Integer pageNo, Integer limit) {
		
		// 为空校验
		pageNo = pageNo == null ? 1 : pageNo;
		limit = limit == null ? CUT_PAGE_LIMIT_MIN : limit;
		
		// 关键字不能为null
		keyword = keyword == null ? "" : keyword;
		// 获取到可查询到的商品总量
		int goodsAllCount = goodsDao.selectCount("%" + keyword + "%");

		// 每页显示条数必须在规定范围内
		limit = limit < CUT_PAGE_LIMIT_MIN ? CUT_PAGE_LIMIT_MIN : limit;
		limit = limit > CUT_PAGE_LIMIT_MAX ? CUT_PAGE_LIMIT_MAX : limit;
		
		// 页数必须在计算得到的范围内
		pageNo = pageNo <= 0 ? 1 : pageNo;
		// 计算最大页数
		int pageAllCount = goodsAllCount % limit == 0 ? goodsAllCount / limit : goodsAllCount / limit + 1;
		pageNo = pageNo > pageAllCount ? pageAllCount : pageNo;
		
		// 确定数据库使用limit语句查询的偏移量
		int offset = (pageNo - 1) * limit;

		// 分页查询商品
		List<Goods> goods = goodsDao.selectAndPagedByName("%" + keyword + "%", offset, limit); 
		
		// 将查询到的总页数放入other中返回
		Map<String, Integer> otherMap = new HashMap<String, Integer>(1);
		otherMap.put("pageAllCount", pageAllCount);
		
		return UiReturn.ok(goods, "查询商品成功", otherMap);
	}

	/**
	 * 通过goods中的实际商品id和表名获取实际商品对象
	 * @param goodsId 商品id，不是实际商品id
	 * @return
	 */
	public UiReturn getRealGoods(String goodsId){
		// TODO 参数校验
		// 获取抽象商品
		Goods goods = goodsDao.selectById(goodsId);
		
		// TODO 为空校验
		// 获取实际商品对应的dao
		RealGoodsBaseDao<?> realGoodsDao = daoPool.getDao(goods.getLinkTable());
		
		// 通过实际商品dao查询到实际商品
		return UiReturn.ok(realGoodsDao.selectById(goods.getRealGoodsId()), "获取成功");
	}
	
	
	public BookDao getBookDao() {
		return bookDao;
	}
	
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
}
