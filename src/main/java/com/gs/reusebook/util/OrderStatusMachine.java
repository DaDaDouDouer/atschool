package com.gs.reusebook.util;

import static com.gs.reusebook.util.ReusebookStatic.*;

/**
 * 
 * 订单状态机，用于控制订单状态的改变，阻止不正确的改变
 * 
 * @author IceAsh
 *
 */
public class OrderStatusMachine {
	
	/**
	 * 
	 * 校验是否能从now状态变为aim状态<br><br>
	 * 
	 * 列举所有的合法改变，判断now到aim的改变是否是其中一种，
	 * 如果是则返回成功，如果不是则返回失败。
	 * 
	 * @param now
	 * @param aim
	 * @return
	 */
	public static boolean changeStatus(int now, int aim){
		
		if((now == ORDER_STATUS_START && aim == ORDER_STATUS_PAYED)
			||(now == ORDER_STATUS_PAYED && aim == ORDER_STATUS_PAYED_OK)
			||(now == ORDER_STATUS_PAYED_OK && aim == ORDER_STATUS_SENDED)
			||(now == ORDER_STATUS_SENDED && aim == ORDER_STATUS_END)){
			
			return true;
		}else{
			return false;
		}
	}
}
