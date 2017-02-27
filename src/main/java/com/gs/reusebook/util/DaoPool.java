package com.gs.reusebook.util;

import java.util.HashMap;
import java.util.Map;

import com.gs.reusebook.dao.base.RealGoodsBaseDao;
import com.gs.reusebook.service.GoodsService;
import com.gs.reusebook.service.ServiceWhichUseDaoPool;
import static com.gs.reusebook.util.ReusebookStatic.TABLE_NAME_BOOK;

/**
 * 用于储存实际商品的dao，对外输出父接口类型RealGoodsDao
 * @author IceAsh
 *
 */
public class DaoPool {
	/**
	 * 存储实际商品类型对饮的dao
	 */
	private Map<String, RealGoodsBaseDao<?>> daoMap = null;
	
	/**
	 * 存储使用该pool的service，需要实现接口ServiceWhichUseDaoPool
	 */
	private ServiceWhichUseDaoPool service = null;
	
	/**
	 * 初始化池，存储service的引用
	 * @param goodsService
	 */
	public void initService(GoodsService goodsService){
		this.service = goodsService; 
	}
	
	/**
	 * 在获取一个具体的dao之前会检查map是否为空，<br>
	 * 如果为空，则会先从service中获取dao填充到map中
	 */
	private void initDaoMap(){
		daoMap = new HashMap<String, RealGoodsBaseDao<?>>();
		daoMap.put(TABLE_NAME_BOOK, service.getBookDao());
	}
	
	/**
	 * 通过表名获取对应的实际商品的dao
	 * @param tableName
	 * @return
	 */
	public RealGoodsBaseDao<?> getDao(String tableName){
		if(daoMap == null){
			initDaoMap();
		}
		return daoMap.get(tableName);
	}
	
}
