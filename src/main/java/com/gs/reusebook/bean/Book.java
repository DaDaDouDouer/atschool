package com.gs.reusebook.bean;

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
	private String description;

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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
