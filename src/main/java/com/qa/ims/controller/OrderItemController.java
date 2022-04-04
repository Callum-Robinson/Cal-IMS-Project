package com.qa.ims.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

public class OrderItemController {

	public static final Logger LOGGER = LogManager.getLogger();
	
	/*
	 * The OrderItem controller requires the OrderItemDAO and utils
	 */
	private OrderItemDAO orderItemDAO;
	private Utils utils = new Utils();
	
	
	/*
	 * Generated constructor from the two fields
	 */
	public OrderItemController(OrderItemDAO orderItemDao, Utils utils) {
		super();
		this.orderItemDAO = orderItemDao;
		this.utils = utils;
	}
	
	
	/*
	 * Creates an order item with ids and quantity
	 * 
	 * @return a OrderItem
	 */
	public OrderItem create(Long orderId) {
		LOGGER.info("Please enter the item id");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter the quantity of the item");
		Integer quantity = utils.getInteger();
		OrderItem orderItem = orderItemDAO.create(new OrderItem(orderId, itemId, quantity));
		LOGGER.info("Item added to order");
		return orderItem;
		
	}
	
	
}
