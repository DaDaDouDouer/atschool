package com.gs.reusebook.bean;

import java.util.List;

public class GoodsType {

	private String id;

	private String name;

	private String baseName;

	private String baseId;
	
	private String linkTable;

	private List<GoodsType> subTypes;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 小类名
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 大类名
	 * 
	 * @return
	 */
	public String getBaseName() {
		return baseName;
	}

	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

	public void setLinkTable(String linkTable) {
		this.linkTable = linkTable;
	}

	/**
	 * 表示该类型用来描述哪个实际商品
	 * 
	 * @return
	 */
	public String getLinkTable() {
		return linkTable;
	}

	public String getBaseId() {
		return baseId;
	}

	public void setBaseId(String baseId) {
		this.baseId = baseId;
	}

	public List<GoodsType> getSubTypes() {
		return subTypes;
	}

	public void setSubTypes(List<GoodsType> subTypes) {
		this.subTypes = subTypes;
	}
	
	/**
	 * TODO: 没有考虑本身为null的情况
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof GoodsType && this.id.equals(((GoodsType)obj).getId())){
			return true;
		}
		return false;
	}
	
	/**
	 * TODO:自定义hashcode的方法可能导致“null”的字符串和null的字符串在哈希判定中为一致
	 */
	@Override
	public int hashCode() {
		if(this.id == null){
			this.id = "null";
		}
		return this.id.hashCode();
	}
}
