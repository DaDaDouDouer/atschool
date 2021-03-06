package com.gs.reusebook.bean;

/**
 * 
 * 一个订单中每个商品的信息
 * 
 * @author IceAsh
 *
 */
public class OrderItem {
	private String id;

	private String orderId;
	private String goodsId;

	private long goodsCount;

	private Goods goods;

	private int status;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public long getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(long goodsCount) {
		this.goodsCount = goodsCount;
	}

	public Goods getGoods() {
		return goods;
	}
	
	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
