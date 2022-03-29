package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAO implements Dao<Item> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	/*
	 * Models the item object from a database result set
	 * 
	 * @param resultset - takes in a result set, the data for each column is added to the appropriate field
	 * 
	 * @return a instance of Item using the constructor with all fields
	 */
	@Override
	public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		String type = resultSet.getString("type");
		String name = resultSet.getString("name");
		String description = resultSet.getString("description");
		Double cost = resultSet.getDouble("cost");
		return new Item(id, type, name, description, cost);
	}


	/*
	 * Reads latest item in the database and calls the modelFromResultSet method
	 * 
	 * @return an object for the latest item in table, if exception caught then return null
	 */
	public Item readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
	
	
	/*
	 * Creates an item in the database
	 * 
	 * @param item - takes in an item object
	 * 
	 * @return the item that has been added to the items table, if exception caught then return null
	 */
	@Override
	public Item create(Item item) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement
						("INSERT INTO items(type, name, description, cost) VALUES (?, ?, ?, ?)");) {
							statement.setString(1, item.getType());
							statement.setString(2, item.getName());
							statement.setString(3, item.getDescription());
							statement.setDouble(4, item.getCost());
							statement.executeUpdate();
							return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
			}
		return null;
	}
	
	/*
	 * Reads all items from the database
	 * 
	 * @return the list of items, if exception caught then return empty list
	 */
	
	@Override
	public List<Item> readAll() {
		try(Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items");) {
			List<Item> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(modelFromResultSet(resultSet));
			}
			return items;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	@Override
	public Item read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item update(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
