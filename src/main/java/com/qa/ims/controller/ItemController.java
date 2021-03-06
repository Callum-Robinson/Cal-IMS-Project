package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	/*
	 * The Item controller requires the ItemDAO and utils
	 */
	private ItemDAO itemDAO;
	private Utils utils;
	
	/*
	 * Generated constructor from the two fields
	 */
	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}
	
	
	/*
	 * Creates an item instance with the user entered fields
	 * 
	 * @return the item
	 */
	@Override
	public Item create() {
		LOGGER.info("Please enter the type of item");
		String type = utils.getString();
		LOGGER.info("Please enter the name of the item");
		String name = utils.getString();
		LOGGER.info("Please enter a description of the item");
		String description = utils.getString();
		LOGGER.info("Please enter the cost of the item");
		Double cost = utils.getDouble();
		Item item = itemDAO.create(new Item(type, name, description, cost));
		LOGGER.info("Item created");
		return item;
	}
	
	
	/*
	 * Reads all items to the console using the logger
	 * 
	 * @return the list of items
	 */
	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	
	/*
	 * Updates an item by taking a user input
	 * 
	 * @return the updated item
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter the type of item");
		String type = utils.getString();
		LOGGER.info("Please enter the name of the item");
		String name = utils.getString();
		LOGGER.info("Please enter a description of the item");
		String description = utils.getString();
		LOGGER.info("Please enter the cost of the item");
		Double cost = utils.getDouble();
		Item item = itemDAO.update(new Item(id, type, name, description, cost));
		LOGGER.info("Item updated");
		return item;
	}

	
	/*
	 * Deletes an item by the id taken from the user input
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		return itemDAO.delete(id);
	}
	
}
