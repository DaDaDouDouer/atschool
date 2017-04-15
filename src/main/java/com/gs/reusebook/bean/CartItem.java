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

	private boolean isSelected;

	private Goods goods;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 买家id
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 商品id
	 * @return
	 */
	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * 实际的商品信息
	 * @return
	 */
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	/**
	 * 购物车中商品的数量
	 * @return
	 */
	public int getGoodsCount() {
		return goodsCount;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	/**
	 * 该商品是否被选中
	 * @return
	 */
	public boolean isSelected() {
		return isSelected;
	}
}
