package com.gs.reusebook.controller.base;

import static com.gs.reusebook.util.ReusebookStatic.*;

public class AuthAdminBaseController extends AuthBaseController{

	public AuthAdminBaseController() {
		super(ADMIN_SESSION_KEY, 
				ADMIN_ID_SESSION_KEY, 
				ADMIN_NAME_SESSION_KEY);
	}
	
}
