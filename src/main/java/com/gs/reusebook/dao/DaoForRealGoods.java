package com.gs.reusebook.dao;

import com.gs.reusebook.bean.RealGoods;

public interface DaoForRealGoods<T extends RealGoods> {
	public T selectById(String id); 
}
