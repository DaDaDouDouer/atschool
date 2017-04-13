package com.gs.reusebook.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Goods;
import com.gs.reusebook.bean.Shop;
import com.gs.reusebook.dao.GoodsDao;
import com.gs.reusebook.dao.ShopDao;
import com.gs.reusebook.util.UiReturn;
import static com.gs.reusebook.util.GlobalStatus.*;
import static com.gs.reusebook.bean.Shop.*;

@Service
public class ShopService {
	
	/**
	 * 用于在数据库存储的时候分割多个id
	 * 这个id的分隔符必须保证能被trim之类的函数切掉
	 */
	private final static String ID_SPLITER = " ";
	
	@Autowired
	private ShopDao shopDao;
	
	@Autowired
	private GoodsDao goodsDao;
	
	/**
	 * 新添加一个店铺（虽然只能添加一个）
	 * @param name
	 * @param sellerId
	 * @return
	 */
	public UiReturn add(String name, String sellerId){
		
		// TODO 参数校验
		// TODO 可能需要校验名字不能重复
		
		Shop shop = shopDao.selectBySellerId(sellerId);
		if(shop != null){
			return UiReturn.notOk("", "只能创建一个店铺", REQ_ERROR_400);
		}
		
		shop = new Shop();
		shop.setId(UUID.randomUUID().toString());
		shop.setName(name);
		shop.setSellerId(sellerId);
		shopDao.insert(shop);
		
		return UiReturn.ok("", "创建成功");
	}
	
	/**
	 * 更新某个字段的字段值
	 * @param fieldName
	 * @param fieldValue
	 * @param sellerId
	 * @return
	 */
	public UiReturn updateGoodIds(String fieldName, List<String> goodIds, String sellerId){
		
		// TODO: 参数校验
		// TODO: 没有校验传入的goodIds是不是都存在，而且是不是他自己的goods
		
		Shop shop = shopDao.selectBySellerId(sellerId);
		if(shop == null){
			return UiReturn.notOk("", "店铺不存在", REQ_ERROR_400);
		}
		
		// 判空
		goodIds = goodIds == null ? new ArrayList<String>() : goodIds;
		
		// 拼合goodId字符串，空格分隔（为了便于trim）
		StringBuffer goodsIdSB = new StringBuffer();
		for(String goodId : goodIds){
			goodsIdSB.append(goodId + ID_SPLITER);
		}
		// 去掉最后一个空格
		String goodIdsStr = goodsIdSB.toString().trim();
		
		// 修改
		if(CAROUSEL_NAME.equals(fieldName)){
			// 修改轮播的商品
			shopDao.updateCarousel(goodIdsStr, sellerId);
			
		}else if(RECOMMAND_NAME.equals(fieldName)){
			// 修改推荐的商品
			shopDao.updateRecommand(goodIdsStr, sellerId);
			
		}else{
			return UiReturn.notOk("", "要修改的字段不存在", REQ_ERROR_400);
		}
		
		return UiReturn.ok("", "修改成功");
	}
	
	/**
	 * 通过卖家id获取一个商铺
	 * @param sellerId
	 * @return
	 */
	public UiReturn getBySellerId(String sellerId){

		// TODO 参数校验

		Shop shop = shopDao.selectBySellerId(sellerId);
		if(shop == null){
			return UiReturn.notOk("", "店铺不存在", REQ_ERROR_400);
		}
		
		if(shop.getCarouselStr() == null || "".equals(shop.getCarouselStr())){
			shop.setCarousel(new ArrayList<Goods>());
		}else{
			List<String> carouselIds = new ArrayList<String>(
					Arrays.asList(shop.getCarouselStr().split(ID_SPLITER)));
			shop.setCarousel(goodsDao.selectByIds(carouselIds));
		}
		
		if(shop.getRecommandStr() == null || "".equals(shop.getRecommandStr())){
			shop.setRecommand(new ArrayList<Goods>());
		}else{
			List<String> recommandIds = new ArrayList<String>(
					Arrays.asList(shop.getRecommandStr().split(ID_SPLITER)));
			shop.setRecommand(goodsDao.selectByIds(recommandIds));
		}
		
		return UiReturn.ok(shop, "查询商铺成功");
	}
	
}
