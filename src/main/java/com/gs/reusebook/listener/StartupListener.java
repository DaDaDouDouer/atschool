package com.gs.reusebook.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.gs.reusebook.service.GoodsTypeService;
import com.gs.reusebook.util.UiReturn;

import static com.gs.reusebook.util.ReusebookStatic.*;

@Service
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private GoodsTypeService goodsTypeService;
	
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//root application context 没有parent，避免执行两次
		if(event.getApplicationContext().getParent() == null){   
			
			saveDefaultBookType();
			
       }  
	}
	
	/**
	 * spring加载完之后向数据库写入默认的商品类型。
	 * 如果已经存在则不写入。
	 */
	private void saveDefaultBookType(){
		UiReturn result = goodsTypeService.selectById(DEFAULT_TYPE_ID);
		if(result.getData() == null){
			goodsTypeService.insert(
					DEFAULT_TYPE_ID,
					DEFAULT_TYPE,
					DEFAULT_TYPE_BASE,
					TABLE_NAME_BOOK);
		}
	}
	
}
