package com.gs.reusebook.paramsbean;

public class CutPageValidatorReturnParams {
	public int offset;
	public int limit;
	public int pageNo;
	public int pageAllCount;
	
	public CutPageValidatorReturnParams(int offset, int limit, int pageNo, int pageAllCount) {
		super();
		this.offset = offset;
		this.limit = limit;
		this.pageNo = pageNo;
		this.pageAllCount = pageAllCount;
	}
}
