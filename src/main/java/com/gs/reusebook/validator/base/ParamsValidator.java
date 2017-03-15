package com.gs.reusebook.validator.base;

import com.gs.reusebook.paramsbean.ValidatorReturnParams;

public abstract class ParamsValidator {
	
	abstract public ValidatorReturnParams validate(Object... params);
	
	

	private final static int ONE_PARAMS_LENGTH = 1;
	
	public ValidatorReturnParams oneStringParamBaseValidate(Object... params){

		// 参数数量校验
		if(null == params || params.length != ONE_PARAMS_LENGTH){
			return new ValidatorReturnParams(false, "传入参数数量只能为" + ONE_PARAMS_LENGTH);
		}
		
		// 入参不为空校验
		Object param = params[0];
		if(param == null){
			return new ValidatorReturnParams(false, "传入参数不能为null");
		}
		
		// 参数类型校验
		if(!(param instanceof String)){
			return new ValidatorReturnParams(false, "传入参数类型只能为String");
		}
		
		return new ValidatorReturnParams(true, "基本验证通过");
	}
}
