package com.gs.reusebook.validator;

import com.gs.reusebook.paramsbean.ValidatorReturnParams;

public class PKIDValidator implements ParamsValidator {

	private final static int PARAMS_LENGTH = 1;
	
	public ValidatorReturnParams validate(Object... params) {
		
		// 参数数量校验
		if(null == params || params.length != PARAMS_LENGTH){
			return new ValidatorReturnParams(false, "传入参数数量只能为" + PARAMS_LENGTH);
		}
		
		// 入参不为空校验
		Object param = params[0];
		if(param == null){
			return new ValidatorReturnParams(false, "传入参数不能为null");
		}
		
		// 参数类型校验
		String pkid = null;
		if(param instanceof String){
			pkid = (String) param;
		}else{
			return new ValidatorReturnParams(false, "传入参数类型只能为String");
		}
		
		// 格式校验
		if(!pkid.matches("[0-9a-z]{8}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{12}")){
			return new ValidatorReturnParams(false, "传入参数格式必须符合主键ID格式");
		}
		
		return new ValidatorReturnParams();
	}

}
