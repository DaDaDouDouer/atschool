package com.gs.reusebook.bean;

import java.util.List;

/**
 * 商家的店铺类，每个商家只有一个店铺
 * @author IceAsh
 *
 */
public class Shop {
	
	private String id;
	
	private String sellerId;
	private String name;
	private String imgUrl;
	
	private Object carouselObj;
	
	private String carouselStr;
	private List<Goods> carousel;
	private String recommandStr;
	private List<Goods> recommand;
	
	/**
	 * 表示轮播字段的常量
	 */
	public static final String CAROUSEL_NAME = "carousel";

	/**
	 * 表示推荐字段的常量
	 */
	public static final String RECOMMAND_NAME = "recommand";
	

	/**
	 * 表示轮播字段的常量
	 */
	public static final String CAROUSEL_URL = "url";

	/**
	 * 表示推荐字段的常量
	 */
	public static final String CAROUSEL_DESC = "desc";
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 对应的卖家id
	 * @return
	 */
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	
	/**
	 * 店铺名
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 店铺图片的url（不是外网的图片）
	 * @return
	 */
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	/**
	 * 轮播要展示的商品id，空格分隔的id，用于数据库储存
	 * @return
	 */
	public String getCarouselStr() {
		return carouselStr;
	}
	public void setCarouselStr(String carouselStr) {
		this.carouselStr = carouselStr;
	}
	
	/**
	 * 轮播要展示的商品id，用于传递给前台
	 * @return
	 */
	public List<Goods> getCarousel() {
		return carousel;
	}
	public void setCarousel(List<Goods> carousel) {
		this.carousel = carousel;
	}
	
	/**
	 * 推荐要展示的商品id，空格分隔的id，用于数据库储存
	 * @return
	 */
	public String getRecommandStr() {
		return recommandStr;
	}
	public void setRecommandStr(String recommandStr) {
		this.recommandStr = recommandStr;
	}
	
	/**
	 * 推荐要展示的商品id，用于传递给前台
	 * @return
	 */
	public List<Goods> getRecommand() {
		return recommand;
	}
	public void setRecommand(List<Goods> recommand) {
		this.recommand = recommand;
	}
	
	
	public Object getCarouselObj() {
		return carouselObj;
	}
	
	public void setCarouselObj(Object carouselObj) {
		this.carouselObj = carouselObj;
	}
	
	
}
