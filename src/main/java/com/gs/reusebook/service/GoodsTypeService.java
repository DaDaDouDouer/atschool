package com.gs.reusebook.service;

import static com.gs.reusebook.util.GlobalStatus.REQ_ERROR_400;
import static com.gs.reusebook.validator.base.ValidatorType.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.GoodsType;
import com.gs.reusebook.dao.GoodsTypeDao;
import com.gs.reusebook.paramsbean.ValidatorReturnParams;
import com.gs.reusebook.util.UiReturn;
import com.gs.reusebook.validator.GeneralValidator;
import com.gs.reusebook.validator.base.ValidatorType;

@Service
public class GoodsTypeService {
	
	@Autowired
	private GoodsTypeDao goodsTypeDao;
	/**
	 * 通过表名查询相关的所有类型
	 * @param linkTable
	 * @return
	 */
	public UiReturn selectByLinkTable(String linkTable){
		// TODO linkTable的参数校验
		
		List<GoodsType> allTypes = goodsTypeDao.selectByLinkTable(linkTable);
		Map<String, List<GoodsType>> totalType = new HashMap<String, List<GoodsType>>();
		// 构建二级菜单
		for(GoodsType type : allTypes){
			String baseName = type.getBaseName();
			
			if(!totalType.containsKey(baseName)){
				totalType.put(baseName, new ArrayList<GoodsType>());
			}
			totalType.get(baseName).add(type);
			
		}
		return UiReturn.ok(totalType, "成功获取该表名下的全部类型");
		
	}
	
	/**
	 * 以键值的形式获取全部的分类
	 * @return
	 */
	public UiReturn selectAll(){
		List<GoodsType> allTypes = goodsTypeDao.selectAll();
		Map<String, Map<String, List<GoodsType>>> totalType = new HashMap<String, Map<String,List<GoodsType>>>();
		// 构建主页显示需要的三级菜单
		for(GoodsType type : allTypes){
			
			String linkTable = type.getLinkTable();
			if(!totalType.containsKey(linkTable)){
				totalType.put(linkTable, new HashMap<String, List<GoodsType>>());
			}
			
			String baseName = type.getBaseName();
			if(!totalType.get(linkTable).containsKey(baseName)){
				totalType.get(linkTable).put(baseName, new ArrayList<GoodsType>());
			}
			totalType.get(linkTable).get(baseName).add(type);
			
		}
		return UiReturn.ok(totalType, "成功获取全部类型");
	}
	
	/**
	 * 通过id获取一个商品分类
	 * @param typeId
	 * @return
	 */
	public UiReturn selectById(String typeId){
		
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(ValidatorType.PKID, typeId);
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		return UiReturn.ok(goodsTypeDao.selectById(typeId), "通过id查询书籍类型成功");
	}
	
	/**
	 * 插入一条商品分类
	 * @param typeId
	 * @param name
	 * @param baseName
	 * @return
	 */
	public UiReturn insert(String typeId, String name, String baseName, String linkTable){
		
		// 参数校验
		// TODO linkTable的参数校验
		ValidatorReturnParams result = GeneralValidator.validate(
				new ValidatorType[]{PKID, STRING_20, STRING_20}, 
				new Object[]{typeId, name, baseName});
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		GoodsType type = new GoodsType();
		type.setId(typeId);
		type.setName(name);
		type.setBaseName(baseName);
		type.setLinkTable(linkTable);
		goodsTypeDao.insert(type);
		return UiReturn.ok("", "插入书籍类型成功");
	}
	
}
