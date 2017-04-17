package com.gs.reusebook.connect;

import org.springframework.stereotype.Component;

import com.gs.reusebook.bean.Book;
import com.gs.reusebook.util.BookConnectProperty;
import com.gs.reusebook.util.HttpUtil;
/**
 * 书籍信息Connect
 * @author HughDing
 *
 */
@Component
public class BookConnect {
	/**
	 * 从接口获取书籍信息
	 * @param isbn
	 * @return
	 */
	public Book getBookInformation(String isbn){
		String serverUrl = BookConnectProperty.getValue("book_url");
		long timeout = Long.parseLong(BookConnectProperty.getValue("book_timeout"));
		serverUrl = serverUrl + isbn;
		try {
			String responseBody = HttpUtil.doGet(serverUrl, timeout);
			System.out.println(responseBody);
			return new Book();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
