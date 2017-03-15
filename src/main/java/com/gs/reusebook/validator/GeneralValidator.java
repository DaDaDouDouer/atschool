package com.gs.reusebook.validator;

import java.util.HashMap;
import java.util.Map;

import com.gs.reusebook.paramsbean.ValidatorReturnParams;
import com.gs.reusebook.validator.base.ParamsValidator;
import com.gs.reusebook.validator.base.ValidatorType;

public class GeneralValidator {

	/**
	 * 数据库主键ID验证器的键
	 */
	private static Map<ValidatorType, ParamsValidator> validatorPool;
	
	static{
		validatorPool = new HashMap<ValidatorType, ParamsValidator>();
		
		validatorPool.put(ValidatorType.PKID, new PKIDValidator());
	}

	/**
	 * 通过传入的key不同获取不同的验证器对传入的参数进行校验
	 * @param validatorType
	 * @param params
	 * @return
	 */
	public static ValidatorReturnParams validate(ValidatorType validatorType, Object... params) {
		
		ParamsValidator validator = validatorPool.get(validatorType);
		
		if(validator == null){
			return new ValidatorReturnParams(false, "不存在此验证器");
		}
		return validator.validate(params);
	}
	
}
