package com.gs.reusebook.bean;

public class Goods {
	private String id;
	private String realGoodsId;
	private String sellerId;
	private String linkTable;

	private String name;
	private double price;
	private long count;

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

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

}
