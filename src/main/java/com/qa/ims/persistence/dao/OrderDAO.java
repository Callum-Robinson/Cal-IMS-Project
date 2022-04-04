package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {

	public static final Logger LOGGER = LogManager.getLogger();
	/*
	 * Models the Order object from a database result set
	 * 
	 * @param resultset - takes in a result set, the data for each column is added to the appropriate field
	 * 
	 * @return an instance of Order using the constructor with all fields
	 */
	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		Long customerId = resultSet.getLong("customer_id");
		LocalDate datePlaced = resultSet.getDate("date_placed").toLocalDate();
		return new Order(id, customerId, datePlaced);
	}
	
	
	public Order modelWithCustomer(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		Long customerId = resultSet.getLong("customer_id");
		String customerName = resultSet.getString("first_name") + " " + resultSet.getString("surname");
		LocalDate datePlaced = resultSet.getDate("date_placed").toLocalDate();
		return new Order(id, customerId, customerName, datePlaced);
	}
	
	
	
	/*
	 * Reads the latest order in the database and calls the method to model the order to a model object
	 * 
	 * @return an object for the latest order in the table, if exception is caught then return null
	 */
	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
	/*
	 * Creates an order in the database
	 * 
	 * @param order - takes in an order object
	 */
	@Override
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement
						("INSERT INTO orders(customer_id, date_placed) VALUES (?, ?)");) {
			statement.setLong(1, order.getCustomerId());
			statement.setObject(2, order.getDatePlaced());
			statement.executeUpdate();
			
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
	@Override
	public Order read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
	@Override
	public List<Order> readAll() {
		try(Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT o.id, o.customer_id, c.first_name, c.surname, "
						+ "o.date_placed FROM orders o JOIN customers c ON o.customer_id = c.id");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelWithCustomer(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}




	@Override
	public int delete(long id) {
		OrderItemDAO orderItemDAO = new OrderItemDAO();
		orderItemDAO.delete(id);
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}


	public int correctOrder(Long customerId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE customer_id = ?");) {
			statement.setLong(1, customerId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Long orderId = modelFromResultSet(resultSet).getId();

				OrderItemDAO orderItemDAO = new OrderItemDAO();
				orderItemDAO.delete(orderId);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		
		
		
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE customer_id = ?");) {
			statement.setLong(1, customerId);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
}
