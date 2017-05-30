package com.gs.reusebook.service.base;

import com.gs.reusebook.util.UiReturn;

public interface AuthBaseService{
	public UiReturn register(String username, String password, String mail);
	public UiReturn login(String username, String password);
}
