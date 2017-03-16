package com.gs.reusebook.validator;

import java.util.HashMap;
import java.util.Map;

import com.gs.reusebook.paramsbean.ValidatorReturnParams;
import com.gs.reusebook.validator.base.ParamsValidator;
import com.gs.reusebook.validator.base.ValidatorType;
import static com.gs.reusebook.validator.base.ValidatorType.*;

public class GeneralValidator {

	/**
	 * 数据库主键ID验证器的键
	 */
	private static Map<ValidatorType, ParamsValidator> validatorPool;

	static {
		validatorPool = new HashMap<ValidatorType, ParamsValidator>();

		validatorPool.put(PKID, new PKIDValidator());
		validatorPool.put(AUTH_USERNAME, new AuthUsernameValidator());
		validatorPool.put(AUTH_PASSWORD, new AuthPasswordValidator());
	}

	/**
	 * 通过传入的key不同获取不同的验证器对传入的参数进行校验
	 * 
	 * @param validatorType
	 * @param params
	 * @return
	 */
	public static ValidatorReturnParams validate(ValidatorType validatorType, Object... params) {

		ParamsValidator validator = validatorPool.get(validatorType);

		if (validator == null) {
			return new ValidatorReturnParams(false, "不存在此验证器");
		}
		return validator.validate(params);
	}

	public static ValidatorReturnParams validate(ValidatorType[] validatorTypes, Object[] params) {
		if (validatorTypes == null || params == null) {
			return new ValidatorReturnParams(false, "传入的校验参数或验证类型为空");
		}
		if (validatorTypes.length != params.length) {
			return new ValidatorReturnParams(false, "参数数量和类型数量不符");
		}
		
		boolean isRight = true;
		String msg = "";
		for (int i = 0; i < validatorTypes.length; i++) {
			ParamsValidator validator = validatorPool.get(validatorTypes[i]);
			if (validator == null) {
				return new ValidatorReturnParams(false, "有验证器不存在");
			}
			
			ValidatorReturnParams result = validator.validate(params[i]);
			
			isRight = isRight && result.isRight;
			msg += "," + result.msg;
		}
		// 去掉打头的逗号
		msg = msg.substring(1).replaceAll(",+", ",");
		
		return new ValidatorReturnParams(isRight, msg);
	}

}
