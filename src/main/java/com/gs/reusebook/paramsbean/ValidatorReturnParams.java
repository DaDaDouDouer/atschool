package com.gs.reusebook.paramsbean;

/**
 * 验证器返回值的标准结构
 * @author IceAsh
 *
 */
public class ValidatorReturnParams {
	
	// 校验结果默认为true
	public boolean isRight = true;
	
	// 返回信息默认为空
	public String msg = "";

	public ValidatorReturnParams() {
	}
	
	public ValidatorReturnParams(boolean result, String msg) {
		super();
		this.isRight = result;
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "" + isRight + "," + msg;
	}
	
}
