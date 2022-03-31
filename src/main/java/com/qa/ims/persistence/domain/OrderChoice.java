package com.qa.ims.persistence.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.utils.Utils;

public enum OrderChoice {

	/*
	 * Choose between orders, items in an order or to return
	 */
	ORDER("A whole order"), ITEM("Items in an order"), RETURN("To return");
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	public String description;
	
	/*
	 * Constructor for the enum
	 */
	private OrderChoice(String description) {
		this.description = description;
	}
	
	/*
	 * get description for printing
	 */
	public String getDescription() {
		return this.name() + ": " + this.description;
	}
	
	/*
	 * print choices
	 */
	public static void printOrderChoices() {
		for (OrderChoice choice : OrderChoice.values()) {
			LOGGER.info(choice.getDescription());
		}
	}
	
	
	/*
	 * pick the choice
	 * 
	 * @param utils - uses the utils class to read user input
	 * 
	 * @return the choice
	 */
	public static OrderChoice getOrderChoice(Utils utils) {
		OrderChoice choice;
		while (true) {
			try {
				choice = OrderChoice.valueOf(utils.getString().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return choice;
	}
}
