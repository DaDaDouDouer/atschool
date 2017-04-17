package com.gs.reusebook.util;

import java.io.InputStream;
import java.util.Properties;

public class BookConnectProperty {
	private Properties properties = new Properties();
	
	private static class PropertyHolder{
		public static final BookConnectProperty property = new BookConnectProperty();
	}
	private BookConnectProperty(){
		try{
			InputStream inputStream = this.getClass().getResourceAsStream("book-connect.properties");
			properties.load(inputStream);
			if(inputStream != null)
				inputStream.close();
		}catch(Exception e){
			System.out.println(e + "file not fount");
		}
	}
	/**
	 * 获取book-connect的配置信息
	 * @param key
	 * @return
	 */
	public static String getValue(String key){
		return PropertyHolder.property.properties.getProperty(key);
	}
}
