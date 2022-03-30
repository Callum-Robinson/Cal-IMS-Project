package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

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
	 * Test the create method in the Item controller by mocking the user input
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
	
}
