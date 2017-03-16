package com.gs.reusebook.validator;

import com.gs.reusebook.paramsbean.ValidatorReturnParams;
import com.gs.reusebook.validator.base.ParamsValidator;

public class String255Validator extends ParamsValidator{

	@Override
	public ValidatorReturnParams validate(Object... params) {
		
		// null，长度，数据类型等基本校验
		ValidatorReturnParams result = oneStringParamBaseValidate(params);
		if(!result.isRight){
			return result;
		}
		
		// 格式校验
		String str = (String) params[0];
		if(str.length() > 255){
			return new ValidatorReturnParams(false, "输入内容超过长度限制");
		}
		
		return new ValidatorReturnParams();
	}
}
