package com.gs.reusebook.controller.base;

import static com.gs.reusebook.util.ReusebookStatic.*;

public class AuthSellerBaseController extends AuthBaseController{

	public AuthSellerBaseController() {
		super(SELLER_SESSION_KEY, 
				SELLER_ID_SESSION_KEY, 
				SELLER_NAME_SESSION_KEY);
	}
	
}
