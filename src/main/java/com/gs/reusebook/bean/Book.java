package com.gs.reusebook.bean;

import java.util.ArrayList;
import java.util.List;

import com.gs.reusebook.bean.base.RealGoods;

/**
 * 
 * 书籍为一种商品，书籍信息
 * 
 * @author IceAsh
 *
 */
public class Book extends RealGoods {
	private String id;

	private String name;
	private String author;
	private String isbn;
	private String imgUrl;
	private List<BookType> types;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public List<BookType> getTypes() {
		return types;
	}

	public void setTypes(List<BookType> types) {
		this.types = types;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public List<String> fatchTypeIds() {
		List<String> typeIds = new ArrayList<String>();
		if (types != null) {
			for (BookType type : types) {
				typeIds.add(type.getId());
			}
		}
		return typeIds;
	}
}
