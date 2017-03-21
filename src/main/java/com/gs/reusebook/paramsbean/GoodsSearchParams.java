package com.gs.reusebook.paramsbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gs.reusebook.bean.GoodsType;

public class GoodsSearchParams {
	
	public String sellerId;
	public String keyword;
	public Integer pageNo;
	public Integer limit;
	
	public String linkTable;
	public Map<String, Object> conditions;
	public List<GoodsType> types;

	public List<String> fatchTypeIds() {
		List<String> typeIds = new ArrayList<String>();
		if (types != null) {
			for (GoodsType type : types) {
				typeIds.add(type.getId());
			}
		}
		return typeIds;
	}
}
