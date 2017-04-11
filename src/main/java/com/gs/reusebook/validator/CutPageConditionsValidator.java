package com.gs.reusebook.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于校验分页查询时传入的筛选条件，放在conditions字段里面的
 * 
 * @author IceAsh
 *
 */
public class CutPageConditionsValidator {

	/**
	 * 用于存放conditions里面能出现的key，但是不需要校验值
	 */
	private static List<String> legalKeys;
	/**
	 * 用于存放conditions里面能出现的key，但是需要校验值，仅限String
	 */
	private static Map<String, List<String>> legalEntries;

	static {
		// 放入legalKeys中的
		String[] legalKeysArray = new String[]{"minPrice", "maxPrice"};
		
		legalKeys = new ArrayList<String>(Arrays.asList(legalKeysArray));
		
		// 放入legalEntries中的
		String[] orderConditionArray = new String[]{"viaOrder", "priceOrder"};
		String[] orderConditionValueArray = new String[]{"asc", "desc"};
		
		legalEntries = new HashMap<String, List<String>>();
		for(int i =0;i<orderConditionArray.length;i++){
			legalEntries.put(orderConditionArray[i],
					new ArrayList<String>(Arrays.asList(orderConditionValueArray)));
		}
	}
	
	/**
	 * 包含于legalKeys或legalEntries中，
	 * 如果是后者，则还要判断conditions的值是不是包含在legalEntries对应的值中
	 * @param conditions
	 * @return
	 */
	static public boolean validate(Map<String, Object> conditions){
		
		for(String key : conditions.keySet()){
			if(legalKeys.contains(key)){
				continue;
			}else{
				if(legalEntries.keySet().contains(key)){
					if(legalEntries.get(key).contains(conditions.get(key))){
						continue;
					}else{
						return false;
					}
				}else{
					return false;
				}
			}
		}
		
		return true;
	}

}
