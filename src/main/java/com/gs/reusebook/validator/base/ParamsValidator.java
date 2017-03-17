package com.gs.reusebook.validator.base;

import com.gs.reusebook.paramsbean.ValidatorReturnParams;

public abstract class ParamsValidator {
	
	abstract public ValidatorReturnParams validate(Object... params);
	

	private final static int ONE_PARAMS_LENGTH = 1;
	
	/**
	 * 对传入的一个参数是String类型的校验
	 * @param params
	 * @return
	 */
	public ValidatorReturnParams oneStringParamBaseValidate(Object... params){

		ValidatorReturnParams result = oneParamBaseValidate(params);
		if(!result.isRight){
			return result;
		}
		
		// 参数类型校验
		if(!(params[0] instanceof String)){
			return new ValidatorReturnParams(false, "传入参数类型只能为String");
		}
		
		return new ValidatorReturnParams(true, "基本验证通过");
	}

	/**
	 * 对传入的一个参数是Integer类型的校验
	 * @param params
	 * @return
	 */
	public ValidatorReturnParams oneIntegerParamBaseValidate(Object... params){

		ValidatorReturnParams result = oneParamBaseValidate(params);
		if(!result.isRight){
			return result;
		}
		
		// 参数类型校验
		if(!(params[0] instanceof Integer)){
			return new ValidatorReturnParams(false, "传入参数类型只能为Integer");
		}
		
		return new ValidatorReturnParams(true, "基本验证通过");
	}
	
	/**
	 * 对于传入是一个的参数数量，null的校验
	 * @param params
	 * @return
	 */
	public ValidatorReturnParams oneParamBaseValidate(Object... params){

		// 参数数量校验
		if(null == params || params.length != ONE_PARAMS_LENGTH){
			return new ValidatorReturnParams(false, "传入参数数量只能为" + ONE_PARAMS_LENGTH);
		}
		
		// 入参不为空校验
		Object param = params[0];
		if(param == null){
			return new ValidatorReturnParams(false, "传入参数不能为null");
		}
		
		return new ValidatorReturnParams(true, "基本验证通过");
	}
	
}
