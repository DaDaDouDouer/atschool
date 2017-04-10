package com.gs.reusebook.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Goods;
import com.gs.reusebook.bean.base.RealGoods;
import com.gs.reusebook.dao.BookDao;
import com.gs.reusebook.dao.GoodsDao;
import com.gs.reusebook.dao.base.RealGoodsBaseDao;
import com.gs.reusebook.paramsbean.CutPageValidatorReturnParams;
import com.gs.reusebook.paramsbean.ValidatorReturnParams;
import com.gs.reusebook.util.DaoPool;
import com.gs.reusebook.util.UiReturn;
import com.gs.reusebook.validator.CutPageParamsValidator;
import com.gs.reusebook.validator.GeneralValidator;
import com.gs.reusebook.validator.base.ValidatorType;

import static com.gs.reusebook.util.GlobalStatus.*;
import static com.gs.reusebook.util.ReusebookStatic.DEFAULT_TYPE_ID;

@Service
public class GoodsService implements ServiceWhichUseDaoPool{

	@Autowired
	private GoodsDao goodsDao;
	
	/**
	 * dao池初始化时候会用到该变量，通过该service的this获取到
	 */
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
	 * @param linkTable
	 * @param typeIds
	 * @param conditions
	 * @return
	 */
	public UiReturn selectAndPaged
		(String keyword, Integer pageNo, Integer limit, String linkTable, List<String> typeIds, Map<String, Object> conditions) {
		
		/* 
		 * 此处condition不参与校验，直接在mapper中通过mybatis的语法取用
		 * TODO:可能会造成500类型错误
		 * 例如，如果order相关的值不是传入asc或desc则直接报错
		 * 后期可能考虑添加针对condition的校验
		 */
		
		// 获取实际商品对应的dao，并检验是否存在实际商品类型
		RealGoodsBaseDao<?> realGoodsDao = daoPool.getDao(linkTable);
		if(realGoodsDao == null){
			return UiReturn.notOk("", "不存在该实际商品类型", REQ_ERROR_400);
		}

		// 校验传入的类型列表
		if(typeIds == null){
			typeIds = new ArrayList<String>();
		}
		if(typeIds.isEmpty()){
			typeIds.add(DEFAULT_TYPE_ID);
		}
		// 校验查询条件
		conditions = conditions == null ? new HashMap<String, Object>() : conditions;
		
		// 1 分页参数校正
		// 关键字null转化为空字符串
		keyword = keyword == null ? "" : keyword;
		// 获取到可查询到的商品总量
		int goodsAllCount = realGoodsDao.selectCount("%" + keyword + "%", typeIds, conditions);
		
		// 特殊的分页校验
		CutPageValidatorReturnParams rst = 
				CutPageParamsValidator.validate(pageNo, limit, goodsAllCount);
		
		
		// 2 分页查询商品
		List<Goods> goods = 
				realGoodsDao.selectAndPaged("%" + keyword + "%", rst.offset, rst.limit, typeIds, conditions);
		
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
		
		// 特殊的分页校验
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
		
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(ValidatorType.PKID, goodsId);
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		// 获取抽象商品
		Goods goods = goodsDao.selectById(goodsId);
		// 为空校验
		if(goods == null){
			return UiReturn.notOk(null, "商品不存在", REQ_ERROR_400);
		}
		
		// 获取实际商品对应的dao
		RealGoodsBaseDao<?> realGoodsDao = daoPool.getDao(goods.getLinkTable());
		RealGoods realGoods = realGoodsDao.selectById(goods.getRealGoodsId());
		goods.setRealGoods(realGoods);
		
		// 通过实际商品dao查询到实际商品
		return UiReturn.ok(goods, "获取成功");
	}
	
	
	public BookDao getBookDao() {
		return bookDao;
	}
	
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
}
