package com.qa.ims.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.utils.Utils;

public enum AddOrRemove {

	/*
	 * Choose between add items to an order, remove items from order or to return
	 */
	ADD("Add an item to an order"), REMOVE("Remove an item from an order"), RETURN("To return");
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	public String description;
	
	/*
	 * Constructor for the enum
	 */
	private AddOrRemove(String description) {
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
		for (AddOrRemove choice : AddOrRemove.values()) {
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
	public static AddOrRemove getAddOrRemove(Utils utils) {
		AddOrRemove choice;
		while (true) {
			try {
				choice = AddOrRemove.valueOf(utils.getString().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return choice;
	}
}
