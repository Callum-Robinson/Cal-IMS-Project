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

import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderItemDAO {

	public static final Logger LOGGER = LogManager.getLogger();

	public OrderItem modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("order_id");
		Long itemId = resultSet.getLong("item_id");
		Integer quantity = resultSet.getInt("quantity");
		return new OrderItem(orderId, itemId, quantity);
	}
	
	public OrderItem modelItemsFromResultSet(ResultSet resultSet) throws SQLException {
		Long itemId = resultSet.getLong("item_id");
		String itemType = resultSet.getString("type");
		String itemName = resultSet.getString("name");
		Double itemCost = resultSet.getDouble("cost");
		Integer quantity = resultSet.getInt("quantity");
		Double totalCostOfItem = itemCost * quantity;
		return new OrderItem(itemId, itemType, itemName, itemCost, quantity, totalCostOfItem);
	}
	
	
	public OrderItem readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery
						("SELECT * FROM orderitems ORDER BY order_id, item_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e);
		}
		return null;
	}


	
	public OrderItem create(OrderItem orderItem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement
						("INSERT INTO orderitems(order_id, item_id, quantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, orderItem.getOrderId());
			statement.setLong(2, orderItem.getItemId());
			statement.setInt(3, orderItem.getQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e);
		}
		return null;
	}
	
	
	public List<OrderItem> readAll(Long orderId) {
		try(Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT oi.item_id, i.type, i.name, i.cost, oi.quantity FROM orderitems oi "
						+ "JOIN items i ON oi.item_id = i.id WHERE oi.order_id = ?");) {		
			statement.setLong(1, orderId);
			List<OrderItem> orderItems = new ArrayList<>();
			
			try (ResultSet resultSet = statement.executeQuery();) {
				while (resultSet.next()) {
					orderItems.add(modelItemsFromResultSet(resultSet));
				}
				return orderItems;
			}
			
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e);
		} catch (Exception ex) {
			LOGGER.debug(ex);
			LOGGER.error(ex.getMessage());
		}
		return new ArrayList<>();
	}


	public int delete(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orderitems WHERE order_id = ?");) {
			statement.setLong(1, orderId);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
	
	
	public int delete(Long orderId, Long itemId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement
						("DELETE FROM orderitems WHERE order_id = ? AND item_id = ?");) {
			statement.setLong(1, orderId);
			statement.setLong(2, itemId);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
}
