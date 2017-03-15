package com.gs.reusebook.validator;

import com.gs.reusebook.paramsbean.ValidatorReturnParams;
import com.gs.reusebook.validator.base.ParamsValidator;
/**
 * 主键ID验证器
 * @author IceAsh
 *
 */
public class PKIDValidator extends ParamsValidator {
	
	public ValidatorReturnParams validate(Object... params) {
		
		// null，长度，数据类型等基本校验
		ValidatorReturnParams result = oneStringParamBaseValidate(params);
		if(!result.isRight){
			return result;
		}
		
		// 格式校验
		String pkid = (String) params[0];
		if(!pkid.matches("[0-9a-z]{8}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{12}")){
			return new ValidatorReturnParams(false, "传入参数格式必须符合主键ID格式");
		}
		
		return new ValidatorReturnParams();
	}

}
