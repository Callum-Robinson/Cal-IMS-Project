package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderItemDAO {

	public static final Logger LOGGER = LogManager.getLogger();
	
	
	/*
	 * Models the joining of item objects with quantity for the order
	 * 
	 * @param resultset - takes in result set, the data for the each column is added to the appropriate field
	 * 
	 * @return an instance of OrderItem using the constructor with no order id
	 */
	
	public OrderItem modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long itemId = resultSet.getLong("i.id");
		String itemType = resultSet.getString("i.type");
		String itemName = resultSet.getString("i.name");
		Double itemCost = resultSet.getDouble("i.cost");
		Integer quantity = resultSet.getInt("oi.quantity");
		return new OrderItem(itemId, itemType, itemName, itemCost, quantity);
	}
	
	
	/*
	 * Read all items in the Order and the quantity
	 * 
	 * @param orderID - takes the id of the order
	 * 
	 * @return a list of OrderItems, if exception caught return null
	 */
	public List<OrderItem> readAllInOrder(Long orderID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement
						("SELECT i.id, i.type, i.name, i.cost, oi.quantity FROM orderitems oi JOIN orders o "
								+ "ON oi.item_id = i.id WHERE oi.order_id = ?");) {
			statement.setLong(1, orderID);
			
			List<OrderItem> orderItems = new ArrayList<>();
			
			try (ResultSet resultSet = statement.executeQuery();) {
				while (resultSet.next()) {
					orderItems.add(modelFromResultSet(resultSet));
				}
				return orderItems;
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}


	
}
