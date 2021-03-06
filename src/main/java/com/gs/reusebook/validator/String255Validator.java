package com.gs.reusebook.validator;

import com.gs.reusebook.validator.base.StringLengthValidator;

/**
 * 规定字符串长度最大为255
 * @author IceAsh
 *
 */
public class String255Validator extends StringLengthValidator{

	static public final int STRING_LENGTH = 20;
	
	@Override
	public int getRequiredLength() {
		return STRING_LENGTH;
	}

}
