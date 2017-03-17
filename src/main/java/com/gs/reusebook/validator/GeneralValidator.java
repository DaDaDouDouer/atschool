package com.gs.reusebook.validator;

import java.util.HashMap;
import java.util.Map;

import com.gs.reusebook.paramsbean.ValidatorReturnParams;
import com.gs.reusebook.validator.base.ParamsValidator;
import com.gs.reusebook.validator.base.ValidatorType;
import static com.gs.reusebook.validator.base.ValidatorType.*;

public class GeneralValidator {

	public final static String SPLIT_CHAR = ";";
	
	
	/**
	 * 数据库主键ID验证器的键
	 */
	private static Map<ValidatorType, ParamsValidator> validatorPool;

	static {
		validatorPool = new HashMap<ValidatorType, ParamsValidator>();

		validatorPool.put(PKID, new PKIDValidator());
		validatorPool.put(AUTH_USERNAME, new AuthUsernameValidator());
		validatorPool.put(AUTH_PASSWORD, new AuthPasswordValidator());
		validatorPool.put(STRING_255, new String255Validator());
		validatorPool.put(STRING_20, new String20Validator());
		validatorPool.put(INT_POSITIVE, new PositiveIntegerValidator());
	}

	/**
	 * 通过传入的key不同获取不同的验证器对传入的参数进行校验<br>
	 * 
	 * 这个方法是对一个或一组有关系的参数进行校验，如<br>
	 * id或username+password<br>
	 * 而不是对一群相同参数进行相同格式的校验，如：<br>
	 * [id1, id2, id3, ...]<br>
	 * 
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
			msg += SPLIT_CHAR + result.msg;
		}
		// 去掉打头的分隔符，以及替换相连的分隔符为一个分隔符
		msg = msg.substring(1).replaceAll(SPLIT_CHAR + "+", SPLIT_CHAR);
		
		return new ValidatorReturnParams(isRight, msg);
	}

}
