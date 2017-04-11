package com.gs.reusebook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Shop;
import com.gs.reusebook.dao.ShopDao;
import com.gs.reusebook.util.UiReturn;
import static com.gs.reusebook.util.GlobalStatus.*;
import static com.gs.reusebook.bean.Shop.*;

@Service
public class ShopService {
	
	@Autowired
	private ShopDao shopDao;
	
	/**
	 * 新添加一个店铺（虽然只能添加一个）
	 * @param name
	 * @param sellerId
	 * @return
	 */
	public UiReturn add(String name, String sellerId){
		
		// TODO 参数校验
		
		Shop shop = shopDao.selectById(sellerId);
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
		
		Shop shop = shopDao.selectById(sellerId);
		if(shop == null){
			return UiReturn.notOk("", "店铺不存在", REQ_ERROR_400);
		}
		
		// 判空
		goodIds = goodIds == null ? new ArrayList<String>() : goodIds;
		
		// 拼合goodId字符串
		StringBuffer goodsIdSB = new StringBuffer();
		for(String goodId : goodIds){
			goodsIdSB.append(goodId + "");
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
	
}
