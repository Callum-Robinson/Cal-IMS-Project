package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderItemController;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderItemControllerTest {
	
	/*
	 * Mock the utils and DAO and injects into the controller
	 */
	@Mock
	private Utils utils;
	
	@Mock
	private OrderItemDAO dao;
	
	@InjectMocks
	private OrderItemController controller;
	

	/*
	 * Test the create method in the Order Item controller by mocking the user input and the DAO create method
	 */
	@Test
	public void testCreate() {
		final Long ORDERID = 1L, ITEMID = 1L;
		final Integer QUANTITY = 3;
		final OrderItem created = new OrderItem(ORDERID, ITEMID, QUANTITY);
		
		Mockito.when(utils.getLong()).thenReturn(ITEMID);
		Mockito.when(utils.getInteger()).thenReturn(QUANTITY);
		Mockito.when(dao.create(created)).thenReturn(created);
		
		assertEquals(created, controller.create(ORDERID));
		
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getInteger();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
}
