package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO DAO = new OrderDAO();
	
	/*
	 * Setup the connection with the test database
	 */
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	
	/*
	 * Test the create method in the Order DAO
	 */
	@Test
	public void testCreate() {
		final Order created = new Order(2L, 1L, LocalDate.of(2022, 4, 2));
		assertEquals(created, DAO.create(created));
	}
}
