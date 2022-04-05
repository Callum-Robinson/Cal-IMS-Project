package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
		final Order created = new Order(3L, 1L, LocalDate.of(2022, 4, 2));
		assertEquals(created, DAO.create(created));
	}
	
	
	/*
	 * Test the read latest method in the Order DAO
	 */
	@Test
	public void testReadLatest() {
		assertEquals(new Order (2L, 1L, LocalDate.of(2022, 4, 3)), DAO.readLatest());
	}
	
	
	/*
	 * Test the read all method in the Order DAO
	 */
	@Test
	public void testReadALL() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order (1L, 1L, "jordan harrison", LocalDate.of(2022, 4, 2)));
		expected.add(new Order (2L, 1L, "jordan harrison", LocalDate.of(2022, 4, 3)));
		assertEquals(expected, DAO.readAll());
	}
	
	
	/*
	 * Test the read by id method
	 */
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Order (ID, 1L, LocalDate.of(2022, 4, 2)), DAO.read(ID));
	}
	
	
	/*
	 * Test the delete method
	 */
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
	
	
	/*
	 * Test the correct order method
	 */
	@Test
	public void testCorrectOrder() {
		assertEquals(2, DAO.correctOrder(1L));
	}
	
}
