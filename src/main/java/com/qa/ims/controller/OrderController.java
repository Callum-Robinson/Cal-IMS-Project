package com.qa.ims.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.Order;
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
	 * Adds an item to the order and asks the user if they want to add more
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


	
	/*
	 * Reads all orders to the console using the logger
	 * It also iterates through the items in each order to be added to the output
	 * 
	 * @return the list of orders
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			order.setOrderItems(orderItemDAO.readAll(order.getId()));
			Double orderTotalCost = 0d;
			for (OrderItem orderItem : order.getOrderItems()) {
				orderTotalCost += orderItem.getTotalCostOfItem();
			}
			LOGGER.info(order);
			LOGGER.info("Total cost of order = " + orderTotalCost);
		}
		return orders;
	}


	
	/*
	 * Gives the user an option to either add an item to an order or remove an item from an order
	 * 
	 * @return - for add item return the new order
	 *         - for delete return null
	 */
	@Override
	public Order update() {
		AddOrRemove choice = null;

		do {
			LOGGER.info("What would you like to do?");
			AddOrRemove.printOrderChoices();

			choice = AddOrRemove.getAddOrRemove(utils);

			switch (choice) {

			case ADD:
				LOGGER.info("Enter the id of the order");
				Long orderId = utils.getLong();

				Order order = orderDAO.read(orderId);
				List<OrderItem> orderItems = new ArrayList<>();
				boolean addMore = true;

				while (addMore) {
					orderItems.add(orderItemController.create(order.getId()));

					boolean yesOrNoGiven = false;
					while (!yesOrNoGiven) {
						LOGGER.info("Do you wish to add another?");
						String userAnswer = utils.getString();

						if (userAnswer.equalsIgnoreCase("NO")) {
							addMore = false;
							yesOrNoGiven = true;
						} else if (userAnswer.equalsIgnoreCase("YES")) {
							yesOrNoGiven = true;
						} else {
							LOGGER.info("Please give a yes or no");
						}
					}
				}
				order.setOrderItems(orderItems);
				return order;
				
				
			case REMOVE:
				LOGGER.info("Please enter the id of the order you would like to delete");
				Long orderId2 = utils.getLong();
				LOGGER.info("Please enter the id of the item you would like to delete");
				Long itemId = utils.getLong();
				orderItemDAO.delete(orderId2, itemId);
				return null;

			case RETURN:
				return null;

			default:
				LOGGER.info("Invalid choice");
				break;
			}
		} while (choice != AddOrRemove.RETURN);
		return null;
	}

	
	/*
	 * Delete the order for order id given by the user
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}

}
