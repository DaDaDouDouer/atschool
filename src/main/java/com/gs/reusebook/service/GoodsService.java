package com.gs.reusebook.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Book;
import com.gs.reusebook.bean.Goods;
import com.gs.reusebook.bean.GoodsType;
import com.gs.reusebook.bean.GoodsTypeRel;
import com.gs.reusebook.bean.base.RealGoods;
import com.gs.reusebook.connect.BookConnect;
import com.gs.reusebook.dao.BookDao;
import com.gs.reusebook.dao.GoodsDao;
import com.gs.reusebook.dao.GoodsTypeDao;
import com.gs.reusebook.dao.GoodsTypeRelDao;
import com.gs.reusebook.dao.base.RealGoodsBaseDao;
import com.gs.reusebook.paramsbean.CutPageValidatorReturnParams;
import com.gs.reusebook.paramsbean.ValidatorReturnParams;
import com.gs.reusebook.util.DaoPool;
import com.gs.reusebook.util.UiReturn;
import com.gs.reusebook.validator.CutPageConditionsValidator;
import com.gs.reusebook.validator.CutPageParamsValidator;
import com.gs.reusebook.validator.GeneralValidator;
import com.gs.reusebook.validator.base.ValidatorType;

import static com.gs.reusebook.util.GlobalStatus.*;
import static com.gs.reusebook.util.ReusebookStatic.DEFAULT_TYPE_ID;
import static com.gs.reusebook.validator.base.ValidatorType.PKID;

@Service
public class GoodsService implements ServiceWhichUseDaoPool{

	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private GoodsTypeDao goodsTypeDao;
	@Autowired
	private GoodsTypeRelDao goodsTypeRelDao;
	
	/**
	 * dao池初始化时候会用到该变量，通过该service的this获取到
	 */
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private BookConnect bookConnect;
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

		// 校验查询条件
		conditions = conditions == null ? new HashMap<String, Object>() : conditions;
		if(!CutPageConditionsValidator.validate(conditions)){
			return UiReturn.notOk("", "conditions填写错误", REQ_ERROR_400);
		}
		
		// 校验传入的类型列表
		if(typeIds == null){
			typeIds = new ArrayList<String>();
		}
		if(typeIds.isEmpty()){
			typeIds.add(DEFAULT_TYPE_ID);
		}
		
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
	public UiReturn selectAndPagedBySellerId(String name, String sellerId, Integer pageNo, Integer limit) {

		// id校验
		ValidatorReturnParams result = GeneralValidator.validate(ValidatorType.PKID, sellerId);
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		// 获取到可查询到的商品总量
		int goodsAllCount = goodsDao.selectCountBySellerId("%" + name + "%", sellerId);
		
		// 特殊的分页校验
		CutPageValidatorReturnParams rst = 
				CutPageParamsValidator.validate(pageNo, limit, goodsAllCount);
		
		// 分页查询商品
		List<Goods> goods = goodsDao.selectAndPagedBySellerId("%" + name + "%", sellerId, rst.offset, rst.limit); 
		
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
	
	/**
	 * 
	 * 更新goods中的某个字段
	 * 
	 * @param goodsId
	 * @param columnName
	 * @param fieldValue
	 * @param sellerId
	 * @return
	 */
	public UiReturn updateGoodsField(String goodsId, String columnName, String fieldValue, String sellerId){
		
		// 校验
		Goods goods = goodsDao.selectById(goodsId);
		if(goods == null){
			return UiReturn.notOk(null, "该商品不存在", REQ_ERROR_400);
		}
		if(!sellerId.equals(goods.getSellerId())){
			return UiReturn.notOk(null, "不能修改其它用户的商品", REQ_ERROR_400);
		}
		
		goodsDao.updateField(goodsId, columnName, fieldValue);
		
		return UiReturn.ok(null, "更新成功");
	}
	/**
	 * 添加goods
	 * @param goods
	 * @param sellerId
	 * @return
	 */
	public UiReturn addGoods(Goods goods, String sellerId){
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(PKID,sellerId);
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		goods.setSellerId(sellerId);
		goods.setId(UUID.randomUUID().toString());
		goodsDao.insertGoods(goods);
		return UiReturn.ok(goods, "添加成功");
	}
	/**
	 * 根据Id删除商品,不做用户验证
	 * @param goodsId
	 * @return
	 */
	public UiReturn deleteGoods(String goodsId){
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(
				new ValidatorType[]{PKID}, 
				new Object[]{goodsId});
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		goodsDao.deleteGoods(goodsId);
		return UiReturn.ok(null, "删除商品成功");
	}
	
	/**
	 * 根据Id删除商品，做用户验证，卖家只有属于自己的订单才能删除
	 * @param goodsId
	 * @return
	 */
	public UiReturn deleteGoods(String goodsId, String sellerId){
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(
				new ValidatorType[]{PKID,PKID}, 
				new Object[]{goodsId,sellerId});
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		Goods goods = goodsDao.selectById(goodsId);
		if(goods != null && goods.getSellerId().equals(sellerId)){
			goodsDao.deleteGoods(goodsId);
			return UiReturn.ok(null, "删除商品成功");
		}
		else{
			return UiReturn.notOk(null, "不能删除其他卖家的订单", REQ_ERROR_400);
		}
	}
	
	public UiReturn updateGoods(String goodsId, Double price, Integer count,String sellerId){
		Goods goods = goodsDao.selectById(goodsId);
		if(goods == null || !goods.getSellerId().equals(sellerId))
			return UiReturn.notOk(null, "不能删除其他卖家的订单", REQ_ERROR_400);
		
		String msg = "";
		if(count >= 0){
			goodsDao.updateCount(goodsId,count);
			msg += "更改数量成功！";
		}
		else
			msg += "数量不能小于零！";
		if(price >= 0){
			goodsDao.updateField(goodsId, "price", price);
			msg += "更改价格成功！";
		}
		else
			msg += "价格不能小于零！";
		
		return UiReturn.ok(null, msg);
	}
	
	public UiReturn addGoodsByIsbn(String isbn, Double price, Integer count,String sellerId){
		Book book = bookConnect.getBookInformation(isbn);
		if(book == null)
			return UiReturn.notOk(null, "获取不到书籍信息", REQ_ERROR_400);
		
		book.setId(UUID.randomUUID().toString());
		Book sameBook = bookDao.selectByIsbn(book.getIsbn());
		
		if(sameBook == null || sameBook.getId() == null || sameBook.getId().isEmpty())
			bookDao.insertBook(book);
		else
			book.setId(sameBook.getId());
			
		Goods goods = new Goods();
		goods.setSellerId(sellerId);
		goods.setId(UUID.randomUUID().toString());
		goods.setRealGoodsId(book.getId());
		
		goods.setName(book.getName());
		goods.setLinkTable("tab_book");
		goods.setImgUrl(book.getImgUrl());
		goods.setDescription(book.getDescription());
		goods.setCount(count);
		goods.setPrice(price);
		goods.setVia(10);
		goodsDao.insertGoods(goods);
		//生成类型
		new Thread(new generateTypeTask(book,goods)).start();
		return UiReturn.ok(goods, "添加成功");
	}
	public BookDao getBookDao() {
		return bookDao;
	}
	
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	public class generateTypeTask implements Runnable{
		private Book book;
		private Goods goods;
		
		public generateTypeTask(Book book, Goods goods) {
			super();
			this.book = book;
			this.goods = goods;
		}

		public void run() {
			List<GoodsType> goodsTypes = goodsTypeDao.selectAll();
			for(GoodsType goodsType : goodsTypes){
				if(goodsType.getName().equals("default_type")){
					GoodsTypeRel goodsTypeRel = new GoodsTypeRel();
					goodsTypeRel.setId(UUID.randomUUID().toString());
					goodsTypeRel.setGoodsId(goods.getId());
					goodsTypeRel.setTypeId(goodsType.getId());
					goodsTypeRelDao.insert(goodsTypeRel);
					continue;
				}
				for(String bookType : book.getTypes()){
					if(bookType.equals(goodsType.getName())){
						GoodsTypeRel goodsTypeRel = new GoodsTypeRel();
						goodsTypeRel.setId(UUID.randomUUID().toString());
						goodsTypeRel.setGoodsId(goods.getId());
						goodsTypeRel.setTypeId(goodsType.getId());
						goodsTypeRelDao.insert(goodsTypeRel);
					}
				}
			}
		}
		
	}
}
