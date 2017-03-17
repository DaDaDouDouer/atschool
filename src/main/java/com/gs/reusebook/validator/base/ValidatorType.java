package com.gs.reusebook.validator.base;

/**
 * 验证器类型的枚举，数量取决于有多少种入参
 * @author IceAsh
 *
 */
public enum ValidatorType {
	PKID,
	AUTH_USERNAME,
	AUTH_PASSWORD,
	STRING_255,
	STRING_20,
	INT_POSITIVE
}
