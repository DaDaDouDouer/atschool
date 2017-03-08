package com.gs.reusebook.bean;

/**
 * 
 * 商品的抽象层，包含商品需要展示的最基本的信息
 * 
 * @author IceAsh
 *
 */
public class Goods {
	private String id;
	/**
	 * 对应实际商品的id
	 */
	private String realGoodsId;
	private String sellerId;
	/**
	 * 表示实际的商品在哪张数据库表中，因为以后可能有多种商品（大概吧）
	 */
	private String linkTable;

	private String name;
	private double price;
	private int count;

	private String imgUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRealGoodsId() {
		return realGoodsId;
	}

	public void setRealGoodsId(String realGoodsId) {
		this.realGoodsId = realGoodsId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getLinkTable() {
		return linkTable;
	}

	public void setLinkTable(String linkTable) {
		this.linkTable = linkTable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getImgUrl() {
		return imgUrl;
	}

}
