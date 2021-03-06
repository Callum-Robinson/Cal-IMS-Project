package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

	/*
	 * Mock the utils and DAO and inject into the controller
	 */
	@Mock
	private Utils utils;
	
	@Mock
	private ItemDAO dao;
	
	@InjectMocks
	private ItemController controller;
	
	
	/*
	 * Test the create method in the Item controller by mocking the user input and the DAO create method
	 */
	@Test
	public void testCreate(){
		final String TYPE = "Donut", NAME = "Ring donut", DESC = "Fresh sugared donut";
		final Double COST = 1.20;
		final Item created = new Item(TYPE, NAME, DESC, COST);
		
		Mockito.when(utils.getString()).thenReturn(TYPE, NAME, DESC);
		Mockito.when(utils.getDouble()).thenReturn(COST);
		Mockito.when(dao.create(created)).thenReturn(created);
		
		assertEquals(created, controller.create());
		
		Mockito.verify(utils, Mockito.times(3)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
	
	
	/*
	 * Test the read all method in the Item controller by mocking the DAO read all method
	 */
	@Test
	public void testReadAll() {
		List <Item> items = new ArrayList<>();
		items.add(new Item (1L, "Ice cream", "Strawberry ice cream", "Classic strawberry flavoured ice cream", 2.99));
		
		Mockito.when(dao.readAll()).thenReturn(items);
		
		assertEquals(items, controller.readAll());
		
		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	
	/*
	 * Test the update method in the Item controller by mocking the user input and DAO update method
	 */
	@Test
	public void testUpdate() {
		Item updated = new Item (2L, "Cake", "Chocolate fudge cake", "Chocolatey fudge cake", 4.89);
		
		Mockito.when(this.utils.getLong()).thenReturn(2L);
		Mockito.when(this.utils.getString()).thenReturn(updated.getType(), updated.getName(), updated.getDescription());
		Mockito.when(this.utils.getDouble()).thenReturn(updated.getCost());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);
		
		assertEquals(updated, this.controller.update());
		
		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(3)).getString();
		Mockito.verify(this.utils, Mockito.times(1)).getDouble();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}
	
	
	/*
	 * Test the delete method in the Item controller by mocking the user input and the DAO delete method
	 */
	@Test
	public void testDelete() {
		final long ID = 1L;
		
		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);
		
		assertEquals(1, this.controller.delete());
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
}
