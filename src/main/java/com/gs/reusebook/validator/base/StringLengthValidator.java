package com.gs.reusebook.validator.base;

import com.gs.reusebook.paramsbean.ValidatorReturnParams;

/**
 * 验证字符串长度的抽象类，实现了校验方法
 * @author IceAsh
 *
 */
public abstract class StringLengthValidator extends ParamsValidator{

	/**
	 * 具体的验证方法
	 */
	@Override
	public ValidatorReturnParams validate(Object... params) {
		
		// null，长度，数据类型等基本校验
		ValidatorReturnParams result = oneStringParamBaseValidate(params);
		if(!result.isRight){
			return result;
		}
		
		// 格式校验
		String str = (String) params[0];
		if(str.length() > getRequiredLength()){
			return new ValidatorReturnParams(false, "输入内容超过长度限制，最长为" + getRequiredLength());
		}
		
		return new ValidatorReturnParams();
	}
	
	/**
	 * 继承类需要实现这个方法，给出字符串长度的要求值
	 * @return
	 */
	abstract public int getRequiredLength();
	
}
