package com.gs.reusebook.bean;

import java.util.Date;

/**
 * 对某个商品的评价
 * 
 * @author IceAsh
 *
 */
public class Evaluation {
	private String id;

	private String goods;
	private String content;
	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
