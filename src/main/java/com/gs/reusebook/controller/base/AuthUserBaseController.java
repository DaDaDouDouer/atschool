package com.gs.reusebook.controller.base;

import static com.gs.reusebook.util.ReusebookStatic.*;

public class AuthUserBaseController extends AuthBaseController{

	public AuthUserBaseController() {
		super(USER_SESSION_KEY, 
				USER_ID_SESSION_KEY, 
				USER_NAME_SESSION_KEY);
	}
	
}
