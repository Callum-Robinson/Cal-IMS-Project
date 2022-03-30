package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {

	private final ItemDAO DAO = new ItemDAO();
	
	/*
	 * Setup up the connection with the test database
	 */
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	
	/*
	 * Test the create method in the Item DAO 
	 */
	@Test
	public void testCreate() {
		final Item created = new Item (2L, "Cake", "Chocolate fudge cake", "Chocolatey fudge cake", 4.89);
		assertEquals(created, DAO.create(created));
	}
	
	
	/*
	 * Test the read latest method in the Item DAO
	 */
	@Test
	public void testReadLatest() {
		assertEquals(new Item (1L, "Ice cream", "Strawberry ice cream", "Classic strawberry flavoured ice cream", 2.99),
				DAO.readLatest());
	}
	
	
	/*
	 * Test the read all method in the Item DAO
	 */
	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L, "Ice cream", "Strawberry ice cream", "Classic strawberry flavoured ice cream", 2.99));
		assertEquals(expected, DAO.readAll());
	}
	
	
	/*
	 * Test the read by id method
	 */
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Item(ID, "Ice cream", "Strawberry ice cream", "Classic strawberry flavoured ice cream", 2.99),
				DAO.read(ID));
	}
	
	
	/*
	 * Test the update method
	 */
	public void testUpdate() {
		final Item updated = new Item (2L, "Cake", "Chocolate fudge cake", "Chocolatey fudge cake", 4.89);
		assertEquals(updated, DAO.update(updated));
	}
}
