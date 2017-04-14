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
	 * condition中用来保存排序值的键
	 */
	private static String SORT_KEY = "sort";
	
	/**
	 * condition中用保存排序的值的分隔符
	 */
	private static String SORT_VALUE_SPLITER = "_";
	
	
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
		
		// 把sort值转化为排序的值
		// 此处假定condition传来的sort值总是对的
		if(conditions.containsKey(SORT_KEY)){
			String sortStr = (String) conditions.get(SORT_KEY);
			String[] entry = sortStr.split(SORT_VALUE_SPLITER);
			conditions.put(entry[0], entry[1]);
			conditions.remove(SORT_KEY);
		}
		
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
