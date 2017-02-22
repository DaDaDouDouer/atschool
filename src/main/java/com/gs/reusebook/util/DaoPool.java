package com.gs.reusebook.util;

import java.util.HashMap;
import java.util.Map;
import com.gs.reusebook.dao.DaoForRealGoods;
import com.gs.reusebook.service.GoodsService;
import com.gs.reusebook.service.ServiceWhichUseDaoPool;

/**
 * 用于储存实际商品的pool，对外输出父接口类型RealGoodsDao
 * @author IceAsh
 *
 */
public class DaoPool {
	private Map<String, DaoForRealGoods<?>> daoMap = null;
	
	private ServiceWhichUseDaoPool service = null;
	
	public void initService(GoodsService goodsService){
		this.service = goodsService; 
	}
	
	private void initDaoMap(){
		daoMap = new HashMap<String, DaoForRealGoods<?>>();
		daoMap.put("tab_book", service.getBookDao());
	}
	
	public DaoForRealGoods<?> getDao(String tableName){
		if(daoMap == null){
			initDaoMap();
		}
		return daoMap.get(tableName);
	}
	
}
