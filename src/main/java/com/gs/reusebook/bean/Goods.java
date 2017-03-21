package com.gs.reusebook.bean;

import java.util.List;

import com.gs.reusebook.bean.base.RealGoods;

/**
 * 
 * 商品的抽象层，包含商品需要展示的最基本的信息
 * 
 * @author IceAsh
 *
 */
public class Goods {

	private String id;
	private String realGoodsId;
	private String sellerId;
	private String linkTable;
	private String name;
	private double price;
	private int count;
	private int via;
	private List<GoodsType> types;
	private String imgUrl;
	private RealGoods realGoods;

	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 对应实际商品的id
	 */
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

	/**
	 * 表示实际的商品在哪张数据库表中，因为以后可能有多种商品（大概吧）
	 */
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

	public void setVia(int via) {
		this.via = via;
	}

	/**
	 * 销量
	 */
	public int getVia() {
		return via;
	}

	public void setTypes(List<GoodsType> types) {
		this.types = types;
	}

	/**
	 * 该商品所具有的分类
	 */
	public List<GoodsType> getTypes() {
		return types;
	}

	public void setRealGoods(RealGoods realGoods) {
		this.realGoods = realGoods;
	}
	
	/**
	 * 该抽象商品所关联的实际商品
	 * @return
	 */
	public RealGoods getRealGoods() {
		return realGoods;
	}
}
