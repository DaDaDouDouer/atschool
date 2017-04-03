package com.gs.reusebook.validator;

import static com.gs.reusebook.util.ReusebookStatic.CUT_PAGE_LIMIT_MAX;
import static com.gs.reusebook.util.ReusebookStatic.CUT_PAGE_LIMIT_MIN;

import com.gs.reusebook.paramsbean.CutPageValidatorReturnParams;

/**
 *  用于分页参数验证的验证器
 * @author IceAsh
 *
 */
public class CutPageParamsValidator {
	
	/**
	 * 
	 * @param pageNo 当前页数
	 * @param limit 每页显示条数
	 * @param itemAllCount 查询到的总量
	 * @return offset 使用LIMIT语句查询数据库时的偏移量
	 */
	public static CutPageValidatorReturnParams 
		validate(Integer pageNo, Integer limit, Integer itemAllCount){

		// 为空校验
		pageNo = pageNo == null ? 1 : pageNo;
		limit = limit == null ? CUT_PAGE_LIMIT_MIN : limit;
		
		// 每页显示条数必须在规定范围内
		limit = limit < CUT_PAGE_LIMIT_MIN ? CUT_PAGE_LIMIT_MIN : limit;
		limit = limit > CUT_PAGE_LIMIT_MAX ? CUT_PAGE_LIMIT_MAX : limit;
		
		// 页数必须在计算得到的范围内
		pageNo = pageNo <= 0 ? 1 : pageNo;
		// 计算最大页数
		int pageAllCount = itemAllCount % limit == 0 ? itemAllCount / limit : itemAllCount / limit + 1;
		pageNo = pageNo > pageAllCount ? pageAllCount : pageNo;
		
		// 页数不能为非正数
		if(pageNo <= 0){
			pageNo = 1;
		}
		
		// 确定数据库使用limit语句查询的偏移量
		int offset = (pageNo - 1) * limit;
		
		return new CutPageValidatorReturnParams(offset, limit, pageNo, pageAllCount);
	}
	
}
