package com.gs.reusebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Book;
import com.gs.reusebook.dao.BookDao;
import com.gs.reusebook.util.UiReturn;
import static com.gs.reusebook.util.ReusebookStatic.*;

@Service
public class BookService {
	
	@Autowired
	private BookDao bookDao;
	
}
