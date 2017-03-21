package com.gs.reusebook.bean;

public class GoodsType {

	private String id;

	private String name;

	private String baseName;

	private String linkTable;

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
}
