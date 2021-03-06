package com.gs.reusebook.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Goods;
import com.gs.reusebook.bean.Shop;
import com.gs.reusebook.dao.GoodsDao;
import com.gs.reusebook.dao.ShopDao;
import com.gs.reusebook.paramsbean.CutPageValidatorReturnParams;
import com.gs.reusebook.paramsbean.ValidatorReturnParams;
import com.gs.reusebook.util.UiReturn;
import com.gs.reusebook.validator.CutPageParamsValidator;
import com.gs.reusebook.validator.GeneralValidator;
import com.gs.reusebook.validator.base.ValidatorType;

import static com.gs.reusebook.util.GlobalStatus.*;
import static com.gs.reusebook.validator.base.ValidatorType.*;
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
		
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(
				new ValidatorType[]{PKID, STRING_30}, new Object[]{sellerId, name});
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		if(StringUtils.isEmpty(name)){
			return UiReturn.notOk(null, "名字不能为空", REQ_ERROR_400);
		}
		// 校验名字不能重复
		Shop shopInDB = shopDao.selectByName(name);
		if(shopInDB != null){
			return UiReturn.notOk(null, "名字重复", REQ_ERROR_400);
		}
		
		// 创建店铺
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
	 * 卖家添加推荐书籍
	 * @param goodsId
	 * @param sellerId
	 * @return
	 */
	public UiReturn addRecommand(String goodsId, String sellerId){
		
		ValidatorReturnParams result = GeneralValidator.validate(
				new ValidatorType[]{PKID, PKID}, new Object[]{goodsId, sellerId});
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		Shop shop = shopDao.selectBySellerId(sellerId);
		String recommandStr = shop.getRecommandStr();
		
		if(StringUtils.isEmpty(recommandStr)){
			recommandStr = "";
		}
		
		Set<String> recommandList = new HashSet<String>(Arrays.asList(recommandStr.split(ID_SPLITER)));
		
		if(recommandList.contains(goodsId)){
			return UiReturn.notOk(null, "已添加该商品", REQ_ERROR_400);
		}else{
			recommandList.add(goodsId);
		}
		
		// 拼合goodId字符串，空格分隔（为了便于trim）
		StringBuffer goodsIdSB = new StringBuffer();
		for(String goodId : recommandList){
			goodsIdSB.append(goodId + ID_SPLITER);
		}
		// 去掉最后一个空格
		String finalRecommandStr = goodsIdSB.toString().trim();
		
		shopDao.updateRecommand(finalRecommandStr, sellerId);
		
		return UiReturn.ok("", "添加成功");
	}
	/**
	 * 卖家删除推荐书籍
	 * @param goodsId
	 * @param sellerId
	 * @return
	 */
	public UiReturn removeRecommand(String goodsId, String sellerId){
		
		ValidatorReturnParams result = GeneralValidator.validate(
				new ValidatorType[]{PKID, PKID}, new Object[]{goodsId, sellerId});
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		Shop shop = shopDao.selectBySellerId(sellerId);
		String recommandStr = shop.getRecommandStr();
		Set<String> recommandList = new HashSet<String>(Arrays.asList(recommandStr.split(ID_SPLITER)));

		if(recommandList.contains(goodsId)){
			recommandList.remove(goodsId);
		}else{
			return UiReturn.notOk(null, "没有添加过该商品", REQ_ERROR_400);
		}
		
		// 拼合goodId字符串，空格分隔（为了便于trim）
		StringBuffer goodsIdSB = new StringBuffer();
		for(String goodId : recommandList){
			goodsIdSB.append(goodId + ID_SPLITER);
		}
		// 去掉最后一个空格
		String finalRecommandStr = goodsIdSB.toString().trim();
		
		shopDao.updateRecommand(finalRecommandStr, sellerId);
		
		return UiReturn.ok("", "删除成功");
	}
	/**
	 * 卖家更新修改某个字段的字段值，（成为推荐）
	 * @param fieldName
	 * @param fieldValue
	 * @param sellerId
	 * @return
	 */
	public UiReturn updateGoodIds(String fieldName, List<String> updateGoodIds, String sellerId){
		
		// 参数校验
		// 因为field会参与if else判断，所以不需要校验
		// goodIds会在之后与数据库中的数据校验，所以不用校验器校验
		ValidatorReturnParams result = GeneralValidator.validate(PKID, sellerId);
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		// 判断店铺是否存在
		Shop shop = shopDao.selectBySellerId(sellerId);
		if(shop == null){
			return UiReturn.notOk("", "店铺不存在", REQ_ERROR_400);
		}
		// 判断goodIds是不是都是自己的
		Set<String> allGoodsIds = new HashSet<String>(goodsDao.selectIdsBySellerId(sellerId)); 
		updateGoodIds = updateGoodIds == null ? new ArrayList<String>() : updateGoodIds;
		for (String id : updateGoodIds) {
			if(!allGoodsIds.contains(id)){
				return UiReturn.notOk(null, "不能使用不属于自己的Goods", REQ_ERROR_400);
			}
		}
		
		// 拼合goodId字符串，空格分隔（为了便于trim）
		StringBuffer goodsIdSB = new StringBuffer();
		for(String goodId : updateGoodIds){
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

		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(PKID, sellerId);
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}

		Shop shop = shopDao.selectBySellerId(sellerId);
		if(shop == null){
			return UiReturn.notOk("", "店铺不存在", REQ_ERROR_400);
		}
		
		// 防止轮播字符串为null造成NPE
		ObjectMapper mapper = new ObjectMapper();
		try {
			String carouselStr = shop.getCarouselStr();
			if(StringUtils.isEmpty(carouselStr)){
				carouselStr = "{}";
			}
			shop.setCarouselObj(mapper.readValue(carouselStr, Object.class));
		} catch (IOException e) {
			e.printStackTrace();
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
	
	public UiReturn updateCarousel(List<Map<String,String>> urlAndDescs, String sellerId){
		
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(PKID, sellerId);
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		List<Map<String,String>> urlAndDescsInDB = new ArrayList<Map<String,String>>();
		// FIXME urlAndDescs 不需要经过参数校验
		for(Map<String,String> urlAndDesc : urlAndDescs){
			if(urlAndDesc.containsKey(CAROUSEL_URL) && urlAndDesc.containsKey(CAROUSEL_DESC)){
				if(StringUtils.isNotEmpty(urlAndDesc.get(CAROUSEL_URL)) && StringUtils.isNotEmpty(urlAndDesc.get(CAROUSEL_DESC))){
					urlAndDescsInDB.add(urlAndDesc);
				}
			}
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String carouselStr = "";
		try {
			carouselStr = mapper.writeValueAsString(urlAndDescsInDB);
		} catch (IOException e) {
			e.printStackTrace();
		}
		shopDao.updateCarousel(carouselStr, sellerId);
		
		return UiReturn.ok("", "修改成功");
	}
	/**
	 * 卖家添加首页轮播图片
	 * @param urlAndDesc
	 * @param sellerId
	 * @return
	 */
	public UiReturn addCarousel(Map<String,String> urlAndDesc, String sellerId){

		// 参数校验
		if(urlAndDesc == null){
			return UiReturn.notOk(null, "输入参数为空", REQ_ERROR_400);
		}
		ValidatorReturnParams result = GeneralValidator.validate(
				new ValidatorType[]{PKID,STRING_255}, new Object[]{sellerId, urlAndDesc.get(CAROUSEL_DESC)});
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		
		JSONObject newJson = new JSONObject(urlAndDesc);
		
		Shop shop = shopDao.selectBySellerId(sellerId);
		String carouselStr = shop.getCarouselStr();
		if(StringUtils.isEmpty(carouselStr)){
			carouselStr = "[]";
		}
		JSONArray carouselJson = new JSONArray(carouselStr);

		Integer removeIndex = null; 
		for(int i = 0; i < carouselJson.length(); i++){
			JSONObject aEntry = (JSONObject)carouselJson.get(i);
			if(aEntry.optString(CAROUSEL_URL).equals(urlAndDesc.get(CAROUSEL_URL))){
				removeIndex = i;
			}
		}
		if(removeIndex != null){
			carouselJson.remove(removeIndex);
		}
		carouselJson.put(newJson);
		
		shopDao.updateCarousel(carouselJson.toString(), sellerId);
		
		return UiReturn.ok("", "增加成功");
	}
	
	/**
	 * 卖家删除首页轮播图片
	 * @param url
	 * @param sellerId
	 * @return
	 */
	public UiReturn removeCarousel(String url, String sellerId){

		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(PKID, sellerId);
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		Shop shop = shopDao.selectBySellerId(sellerId);
		String carouselStr = shop.getCarouselStr();
		JSONArray carouselJson = new JSONArray(carouselStr);
		
		Integer removeIndex = null; 
		for(int i = 0; i < carouselJson.length(); i++){
			JSONObject aEntry = (JSONObject)carouselJson.get(i);
			if(aEntry.optString(CAROUSEL_URL).equals(url)){
				removeIndex = i;
				break;
			}
		}
		if(removeIndex != null){
			carouselJson.remove(removeIndex);
		}else{
			return UiReturn.notOk(null, "没有添加过该轮播", REQ_ERROR_400);
		}
		shopDao.updateCarousel(carouselJson.toString(), sellerId);
		
		return UiReturn.ok("", "删除成功");
	}

	
	public UiReturn updateShopName(String name, String id){
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(
				new ValidatorType[]{PKID, STRING_30}, new Object[]{id, name});
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		shopDao.updateName(name, id);
		return UiReturn.ok(null, "更改店铺名成功");
	}
	public UiReturn selectAndPagedByName(String name, Integer pageNo, Integer limit){
		if(name == null)
			name = "";
		// 获取到可查询到的店铺总量
		int shopAllCount = shopDao.selectCountByName("%"+ name + "%");
						
		// 特殊的分页校验
		CutPageValidatorReturnParams rst = 
		CutPageParamsValidator.validate(pageNo, limit, shopAllCount);
		
		// 分页查询用户
		List<Shop> shop = shopDao.selectAndPagedByName("%"+ name + "%", rst.offset, rst.limit); 
						
		// 将查询到的总页数放入other中返回
		Map<String, Integer> otherMap = new HashMap<String, Integer>(1);
		otherMap.put("pageAllCount", rst.pageAllCount);
						
		return UiReturn.ok(shop, "获取店铺成功", otherMap);	
	}
	public UiReturn deleteShop(String shopId){
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(PKID, shopId);
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}

		shopDao.deleteShop(shopId);
		return UiReturn.ok(null, "删除店铺成功");
	}
}
