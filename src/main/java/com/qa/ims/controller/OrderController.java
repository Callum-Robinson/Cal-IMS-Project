package com.qa.ims.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderChoice;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	/*
	 * The Order controller requires the Order DAO and utils
	 */
	private OrderDAO orderDAO;
	private OrderItemDAO orderItemDAO = new OrderItemDAO();
	private Utils utils = new Utils();
	private OrderItemController orderItemController = new OrderItemController(orderItemDAO, utils);
	
	/*
	 * Generated constructor from two fields
	 */
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}
	
	
	/*
	 * Sets the date from user input
	 * 
	 * @return date and a LocalDate object
	 */
	public LocalDate dateSetter() {
		
		LOGGER.info("Enter the day date for when the order was placed");
		int dayOfMonth = utils.getInteger();
		LOGGER.info("Enter the month date for when the order was placed");
		int monthOfYear = utils.getInteger();
		LOGGER.info("Enter the year for when the order was placed");
		int year = utils.getInteger();
		return LocalDate.of(year, monthOfYear, dayOfMonth);
	}
	
	/*
	 * Creates an order instance with user entered fields
	 * Gives option to add a whole order or just an order item
	 * 
	 * @return the order
	 */
	@Override
	public Order create() {
		
		LOGGER.info("Please enter the customer id");
		Long customerId = utils.getLong();
		LocalDate datePlaced = dateSetter();
		Order order = orderDAO.create(new Order(customerId, datePlaced));

		List<OrderItem> orderItems = new ArrayList<>();
		boolean addMore = true;

		while (addMore) {
			orderItems.add(orderItemController.create(order.getId()));

			boolean yesOrNoGiven = false;

			while (!yesOrNoGiven) {
				LOGGER.info("Do you wish to add another");
				String userAnswer = utils.getString();

				if (userAnswer.equalsIgnoreCase("no")) {
					addMore = false;
					yesOrNoGiven = true;
				} else if (userAnswer.equalsIgnoreCase("yes")) {
					yesOrNoGiven = true;
				} else {
					LOGGER.info("Please give a yes or no");
				}
			}
		}
		
		order.setOrderItems(orderItems);
		return order;
	}



	
	
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			order.setOrderItems(orderItemDAO.readAll(order.getId()));
			LOGGER.info(order);
		}
		return orders;
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
