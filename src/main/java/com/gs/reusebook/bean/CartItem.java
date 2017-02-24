package com.gs.reusebook.bean;

/**
 * 购物车项，和用户、商品关联<br>
 * 用户每加入购物车一个商品，数据库就增加一行
 * 
 * @author IceAsh
 *
 */
public class CartItem {
	private String id;

	private String userId;
	private String goodsId;

	private int goodsCount;
	
	private Goods goods;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	
	public int getGoodsCount() {
		return goodsCount;
	}
}
