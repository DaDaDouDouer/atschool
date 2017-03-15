package com.gs.reusebook.validator;

import com.gs.reusebook.paramsbean.ValidatorReturnParams;
import com.gs.reusebook.validator.base.ParamsValidator;

/**
 * 
 * 登陆用户名格式校验<br>
 * 基本校验<br>
 * 只能由大小写英文字母数字下划线空格组成<br>
 * 用户名前后的空格会被截掉，连续的空格会变成一个空格<br>
 * 截掉之后的长度必须在6-20之间
 * 
 * @author IceAsh
 *
 */
public class AuthUsernameValidator extends ParamsValidator{

	@Override
	public ValidatorReturnParams validate(Object... params) {

		// null，长度，数据类型等基本校验
		ValidatorReturnParams result = oneStringParamBaseValidate(params);
		if(!result.isRight){
			return result;
		}
		
		// 格式校验
		
		String username = (String) params[0];
		// 去除前后空格，之后把连续的空格变成一个空格
		username = username.trim().replaceAll(" +", " ");
		// 这里下划线后面有个空格
		if(!username.matches("^[\\w_ ]{6,20}$")){
			return new ValidatorReturnParams(false, "传入参数格式必须符合username格式");
		}
		
		return new ValidatorReturnParams();
	}
	
}
