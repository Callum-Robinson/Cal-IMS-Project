package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List;

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
	private OrderItemDAO orderItemDao;
	private Utils utils;
	
	
	/*
	 * Generated constructor from the two fields
	 */
	public OrderItemController(OrderItemDAO orderItemDao, Utils utils) {
		super();
		this.orderItemDao = orderItemDao;
		this.utils = utils;
	}
	
	
	/*
	 * Creates a list of items and quantities with user entered fields
	 * 
	 * @param orderId - takes the order id to add items to
	 * 
	 * @return the list of OrderItems
	 */
	public List<OrderItem> add(Long orderId) {
		boolean addMore = true;
		List<OrderItem> orderItems = new ArrayList<>();
		
		while (addMore) {
			LOGGER.info("Please enter the item id");
			Long itemId = utils.getLong();
			LOGGER.info("Please enter the quantity ordered");
			Integer quantity = utils.getInteger();
			
			orderItems.add(new OrderItem(orderId, itemId, quantity));
			
			boolean yesOrNoGiven = false;
			
			while (!yesOrNoGiven) {
				LOGGER.info("Do you wish to add another");
				String userAnswer = utils.getString().toUpperCase();
				if (userAnswer == "NO") {
					addMore = false;
					yesOrNoGiven = true;
				} else if (userAnswer == "Yes") {
					yesOrNoGiven = true;
				} else {
					LOGGER.info("Please give a yes or no");
				}
			}
			
		}
		
		return null;
	}
}
