package com.gs.reusebook.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Goods;
import com.gs.reusebook.bean.Order;
import com.gs.reusebook.bean.OrderItem;
import com.gs.reusebook.dao.GoodsDao;
import com.gs.reusebook.dao.OrderDao;
import com.gs.reusebook.dao.OrderItemDao;
import com.gs.reusebook.paramsbean.ValidatorReturnParams;
import com.gs.reusebook.util.UiReturn;
import com.gs.reusebook.validator.GeneralValidator;
import com.gs.reusebook.validator.base.ValidatorType;

import static com.gs.reusebook.util.ReusebookStatic.*;
import static com.gs.reusebook.util.GlobalStatus.*;

@Service
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderItemDao orderItemDao; 
	
	@Autowired
	private GoodsDao goodsDao;
	
	
	
	/**
	 * 查询某卖家的所有订单
	 * @param sellerId
	 * @return
	 */
	public UiReturn selectAllBySellerId(String sellerId){
		
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(ValidatorType.PKID, sellerId);
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		return UiReturn.ok(orderDao.selectAllBySellerId(sellerId), "查询卖家订单成功");
	}
	
	/**
	 * 查询某买家的所有订单
	 * @param userId
	 * @return
	 */
	public UiReturn selectAllByUserId(String userId){
		
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(ValidatorType.PKID, userId);
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		
		return UiReturn.ok(orderDao.selectAllByUserId(userId), "查询买家订单成功");
	}
	
	/**
	 * 通过商品id生成订单
	 * @param userId
	 * @param goodsIds
	 * @return
	 */
	public UiReturn insertOrder(String userId, Map<String, Integer> goodsIdAndCount){
		
		// 参数校验
		ValidatorReturnParams result = GeneralValidator.validate(ValidatorType.PKID, userId);
		if(!result.isRight){
			return UiReturn.notOk(null, result.msg, REQ_ERROR_400);
		}
		// TODO list的参数校验
		
		List<Goods> goods = goodsDao.selectByIds(new ArrayList<String>(goodsIdAndCount.keySet()));

		Map<String, Order> orders = new HashMap<String, Order>();
		// 先构建所有的order
		for (Goods oneGoods : goods) {
			String sellerId = oneGoods.getSellerId();
			// 如果不存在该卖家的订单，则新生成
			if (!orders.containsKey(sellerId)) {
				Order order = new Order();
				order.setId(UUID.randomUUID().toString());
				order.setOrderItems(new ArrayList<OrderItem>());
				order.setSellerId(sellerId);
				order.setStatus(ORDER_STATUS_START);
				order.setUserId(userId);
				
				orders.put(sellerId, order);
			}
			// 向卖家的订单里追加订单项
			Order order = orders.get(sellerId);
			OrderItem orderItem = new OrderItem();
			orderItem.setId(UUID.randomUUID().toString());
			
			// 修改库中商品的数量，如果数量不够则不能生成订单
			String goodsId = oneGoods.getId();
			int requestCount = goodsIdAndCount.get(goodsId);
			if(oneGoods.getCount() < requestCount){
				return UiReturn.notOk("", "商品的数量不够", REQ_ERROR_400);
			}else{
				oneGoods.setCount(oneGoods.getCount() - requestCount);
			}
			
			orderItem.setGoodsCount(requestCount);
			orderItem.setGoodsId(goodsId);
			orderItem.setOrderId(order.getId());
			
			order.getOrderItems().add(orderItem);
		}
		
		// 更新数据库商品数量信息
		for(Goods oneGoods : goods){
			goodsDao.updateCount(oneGoods.getId(), oneGoods.getCount());
		}
		// 循环订单，入库
		for(Order order : orders.values()){
			for(OrderItem orderItem : order.getOrderItems()){
				orderItemDao.insertOrderItem(orderItem);
			}
			orderDao.insertOrder(order);
		}
		
		// TODO 这里要返回什么数据
		return UiReturn.ok("", "生成订单成功");
	}
}
