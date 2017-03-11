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
import com.gs.reusebook.paramsbean.CutPageValidatorReturnParams;
import com.gs.reusebook.paramsbean.ValidatorReturnParams;
import com.gs.reusebook.util.DaoPool;
import com.gs.reusebook.util.UiReturn;
import com.gs.reusebook.validator.CutPageParamsValidator;
import com.gs.reusebook.validator.GeneralValidator;
import com.gs.reusebook.validator.ValidatorType;

import static com.gs.reusebook.util.GlobalStatus.*;

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
		
		// 关键字不能为null
		keyword = keyword == null ? "" : keyword;
		// 获取到可查询到的商品总量
		int goodsAllCount = goodsDao.selectCountByName("%" + keyword + "%");
		
		CutPageValidatorReturnParams rst = 
				CutPageParamsValidator.validate(pageNo, limit, goodsAllCount);
		
		// 分页查询商品
		List<Goods> goods = goodsDao.selectAndPagedByName("%" + keyword + "%", rst.offset, rst.limit); 
		
		// 将查询到的总页数放入other中返回
		Map<String, Integer> otherMap = new HashMap<String, Integer>(1);
		otherMap.put("pageAllCount", rst.pageAllCount);
		
		return UiReturn.ok(goods, "查询商品成功", otherMap);
	}

	/**
	 * 分页获取卖家的所有商品
	 * @param keyword
	 * @param pageNo
	 * @param limit
	 * @return
	 */
	public UiReturn selectAndPagedBySellerId(String sellerId, Integer pageNo, Integer limit) {

		// id校验
		ValidatorReturnParams result = GeneralValidator.validate(ValidatorType.PKID, sellerId);
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		// 获取到可查询到的商品总量
		int goodsAllCount = goodsDao.selectCountBySellerId(sellerId);
		
		CutPageValidatorReturnParams rst = 
				CutPageParamsValidator.validate(pageNo, limit, goodsAllCount);
		// 分页查询商品
		List<Goods> goods = goodsDao.selectAndPagedBySellerId(sellerId, rst.offset, rst.limit); 
		
		// 将查询到的总页数放入other中返回
		Map<String, Integer> otherMap = new HashMap<String, Integer>(1);
		otherMap.put("pageAllCount", rst.pageAllCount);
		
		return UiReturn.ok(goods, "获取商户的商品成功", otherMap);
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
