package com.gs.reusebook.dao.base;

import com.gs.reusebook.bean.base.RealGoods;

public interface RealGoodsBaseDao<T extends RealGoods> {
	public T selectById(String id); 
}
