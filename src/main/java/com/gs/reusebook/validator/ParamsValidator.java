package com.gs.reusebook.validator;

import com.gs.reusebook.paramsbean.ValidatorReturnParams;

public interface ParamsValidator {
	public ValidatorReturnParams validate(Object... params);
}
