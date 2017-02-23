package com.gs.reusebook.dao;

import com.gs.reusebook.bean.DeliveryAddress;

/**
 * 
 * @author IceAsh
 *
 */
public interface DeliveryAddressDao {
	
	public DeliveryAddress selectById(String id);
	public int insertDeliveryAddress(DeliveryAddress deliveryAddress);
	public void deleteDeliveryAddress(String id);
}
