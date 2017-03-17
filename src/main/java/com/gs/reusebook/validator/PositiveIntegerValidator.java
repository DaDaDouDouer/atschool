package com.gs.reusebook.validator;

import com.gs.reusebook.paramsbean.ValidatorReturnParams;
import com.gs.reusebook.validator.base.ParamsValidator;
/**
 * 正整数（数量等）验证器
 * @author IceAsh
 *
 */
public class PositiveIntegerValidator extends ParamsValidator {
	
	@Override
	public ValidatorReturnParams validate(Object... params) {
		
		// null，长度，数据类型等基本校验
		ValidatorReturnParams result = oneIntegerParamBaseValidate(params);
		if(!result.isRight){
			return result;
		}
		
		// 格式校验
		Integer num = (Integer) params[0];
		if(num < 0){
			return new ValidatorReturnParams(false, "传入参数格式必须必须是正整数");
		}
		
		return new ValidatorReturnParams();
	}

}
