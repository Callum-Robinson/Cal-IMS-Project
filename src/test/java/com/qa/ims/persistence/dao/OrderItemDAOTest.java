package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
		final OrderItem created = new OrderItem (2L, 1L, 5);
		assertEquals(created, DAO.create(created));
	}
	
	
	
	/*
	 * Test the read latest method in the Order Item DAO
	 */
	@Test
	public void testReadLatest() {
		assertEquals(new OrderItem (1L, 1L, 3), DAO.readLatest());
	}
	
	
	
	/*
	 * Test the read all method in the Order Item DAO
	 */
	@Test
	public void testReadAll() {
		final long ORDERID = 1L;
		List<OrderItem> expected = new ArrayList<>();
		expected.add(new OrderItem (1L, "Ice cream", "Strawberry ice cream", 2.99, 3, 8.97));
		assertEquals(expected, DAO.readAll(ORDERID));
	}

	
	/*
	 * Test the first delete method
	 */
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1L));
	}
	
	
	/*
	 * Test the second delete method (with order id and item id)
	 */
	@Test
	public void testOverloadedDelete() {
		assertEquals(1, DAO.delete(1L, 1L));
	}
	
	
	
	
}
