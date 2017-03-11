package com.gs.reusebook.validator;

import java.util.HashMap;
import java.util.Map;

import com.gs.reusebook.paramsbean.ValidatorReturnParams;

public class GeneralValidator {

	/**
	 * 数据库主键ID验证器的键
	 */
	public final static Integer PKID = 0;
	
	private static Map<Integer, ParamsValidator> validatorPool;
	
	static{
		validatorPool = new HashMap<Integer, ParamsValidator>();
		
		validatorPool.put(PKID, new PKIDValidator());
	}

	/**
	 * 通过传入的key不同获取不同的验证器对传入的参数进行校验
	 * @param validatorKey
	 * @param params
	 * @return
	 */
	public static ValidatorReturnParams validate(Integer validatorKey, Object... params) {
		
		ParamsValidator validator = validatorPool.get(validatorKey);
		
		if(validator == null){
			return new ValidatorReturnParams(false, "不存在此验证器");
		}
		return validator.validate(params);
	}
	
}
