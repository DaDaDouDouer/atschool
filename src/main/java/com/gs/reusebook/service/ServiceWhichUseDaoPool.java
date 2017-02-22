package com.gs.reusebook.service;

import com.gs.reusebook.dao.BookDao;

public interface ServiceWhichUseDaoPool {
	public BookDao getBookDao();
}
