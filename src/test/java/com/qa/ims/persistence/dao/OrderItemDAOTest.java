package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderItemDAOTest {

	private final OrderItemDAO DAO = new OrderItemDAO();
	
	/*
	 * Setup the connection with the test database
	 */
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	
	/*
	 * Test the create method in the Order Item DAO
	 */
	@Test
	public void testCreate() {
		final OrderItem created = new OrderItem (2L, 1L, 3);
		assertEquals(created, DAO.create(created));
	}
	
	
	
}
