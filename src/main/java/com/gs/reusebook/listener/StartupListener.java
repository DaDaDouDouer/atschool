package com.gs.reusebook.listener;

import static com.gs.reusebook.util.ReusebookStatic.*;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Seller;
import com.gs.reusebook.bean.Shop;
import com.gs.reusebook.dao.SellerDao;
import com.gs.reusebook.dao.ShopDao;
import com.gs.reusebook.service.GoodsTypeService;
import com.gs.reusebook.util.UiReturn;

@Service
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private GoodsTypeService goodsTypeService;
	
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private SellerDao sellerDao;
	
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//root application context 没有parent，避免执行两次
		if(event.getApplicationContext().getParent() == null){   
			
			saveDefaultBookType();
			setIndexShop();
       }  
	}
	
	/**
	 * spring加载完之后向数据库写入默认的商品类型。
	 * 如果已经存在则不写入。
	 */
	private void saveDefaultBookType(){
		UiReturn result = goodsTypeService.selectById(DEFAULT_TYPE_ID);
		
		// TODO: 这里要判断查到的id是不是那个id，而且到时候要考虑是不是只能查到一个
		
		if(result.getData() == null){
			goodsTypeService.insert(
					DEFAULT_TYPE_ID,
					DEFAULT_TYPE,
					DEFAULT_TYPE_BASE,
					TABLE_NAME_BOOK,
					DEFAULT_TYPE_BASE_ID
					);
		}
	}
	
	/**
	 * 增加默认的首页用户和商铺
	 */
	private void setIndexShop(){
		List<Seller> sellers = sellerDao.selectByName(INDEX_Seller_NAME);
		
		if(sellers == null || sellers.isEmpty()){
			Seller seller = new Seller();
			seller.setId(INDEX_SELLER_ID);
			seller.setUsername(INDEX_Seller_NAME);
			seller.setPassword(INDEX_Seller_PASSWORD);
			seller.setCreateTime(new Date());
			
			sellerDao.insert(seller);
		}
		
		Shop shop = shopDao.selectBySellerId(INDEX_SELLER_ID);
		if(shop == null){
			shop = new Shop();
			shop.setId(INDEX_SHOP_ID);
			shop.setName(INDEX_SHOP_NAME);
			shop.setImgUrl(INDEX_SHOP_IMGURL);
			shop.setSellerId(INDEX_SELLER_ID);
			
			shopDao.insert(shop);
		}
		
	}
	
}
