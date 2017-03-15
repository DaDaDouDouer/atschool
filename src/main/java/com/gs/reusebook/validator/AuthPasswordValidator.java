package com.gs.reusebook.validator;

import com.gs.reusebook.paramsbean.ValidatorReturnParams;
import com.gs.reusebook.validator.base.ParamsValidator;

/**
 * 
 * 登陆密码格式校验<br>
 * 基本校验<br>
 * 只能由大小写英文字母数字下划线组成<br>
 * 长度必须在6-20之间
 * 
 * @author IceAsh
 *
 */
public class AuthPasswordValidator extends ParamsValidator{

	@Override
	public ValidatorReturnParams validate(Object... params) {

		// null，长度，数据类型等基本校验
		ValidatorReturnParams result = oneStringParamBaseValidate(params);
		if(!result.isRight){
			return result;
		}
		
		// 格式校验
		String username = (String) params[0];
		/*
		 *  正则表达式特殊字符在[]中会变为普通字符，除了 \ [ ] : ^ -
		 *  所以^要转义 
		 */
		if(!username.matches("^[\\w_!@#$%\\^&*?.]{6,20}$")){
			return new ValidatorReturnParams(false, "传入参数格式必须符合password格式");
		}
		
		return new ValidatorReturnParams();
	}
	
}
