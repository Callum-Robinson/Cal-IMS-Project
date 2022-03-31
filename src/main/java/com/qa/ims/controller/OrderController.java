package com.qa.ims.controller;

import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderChoice;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	/*
	 * The Order controller requires the Order DAO and utils
	 */
	private OrderDAO orderDAO;
	private Utils utils;
	
	/*
	 * Generated constructor from two fields
	 */
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}
	
	
	/*
	 * Creates an order instance with user entered fields
	 * Gives option to add a whole order or just an order item
	 * 
	 * @return the order
	 */
	@Override
	public Order create() {
		
		OrderChoice choice = null;
		do {
			LOGGER.info("Which would you like to create?");
			OrderChoice.printOrderChoices();
			
			choice = OrderChoice.getOrderChoice(utils);
			
			switch (choice) {
			case ORDER:
				Calendar c = Calendar.getInstance();
				
				LOGGER.info("Please enter the customer id");
				String customerId = utils.getString();
				LOGGER.info("Enter the month the order was placed");
				c.set(Calendar.MONTH, utils.getInteger());
				
				return null;
			case ITEM:
				LOGGER.info("Do That");
				return null;
			case STOP:
				return null;
			default:
				LOGGER.info("ERROR");
				break;
			}
			
		} while (choice != OrderChoice.STOP);
		
		return null;
	}
	
	
	
	@Override
	public List<Order> readAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Order update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

}
