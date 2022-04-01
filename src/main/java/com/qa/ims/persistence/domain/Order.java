package com.qa.ims.persistence.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
	
	private Long id;
	private Long customerId;
	private LocalDate datePlaced;
	private List<OrderItem> orderItems = new ArrayList<>();
	
	private String customerName;
	
	/*
	 * Constructors
	 */
	public Order(Long id, Long customerId,LocalDate datePlaced, List<OrderItem> orderItems) {
		super();
		this.setId(id);
		this.setCustomerId(customerId);
		this.setDatePlaced(datePlaced);
		this.setOrderItems(orderItems);
	}
	
	
	
	public Order(Long customerId, LocalDate datePlaced, List<OrderItem> orderItems) {
		super();
		this.setCustomerId(customerId);
		this.setDatePlaced(datePlaced);
		this.setOrderItems(orderItems);
	}
	
	
	public Order(Long id, Long customerId, LocalDate datePlaced) {
		super();
		this.setId(id);
		this.setCustomerId(customerId);
		this.setDatePlaced(datePlaced);
	}
	
	
	public Order(Long customerId, LocalDate datePlaced) {
		super();
		this.setCustomerId(customerId);
		this.setDatePlaced(datePlaced);
	}


	public Order(Long id, Long customerId, String customerName, LocalDate datePlaced) {
		super();
		this.setId(id);
		this.setCustomerId(customerId);
		this.setCustomerName(customerName);
		this.setDatePlaced(datePlaced);
	}

	/*
	 * Getters and Setters
	 */
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public LocalDate getDatePlaced() {
		return datePlaced;
	}


	public void setDatePlaced(LocalDate datePlaced) {
		this.datePlaced = datePlaced;
	}
	
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}



	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	
	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	
	/*
	 * Generate the toString, hashcode and equals overrides
	 */
	@Override
	public String toString() {
		return "Order [Id = " + id + ", Customer Id = " + customerId + ", Customer Name = " + customerName + ", Date Placed = "
				+ datePlaced + ", Items in order = " + orderItems + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(customerId, datePlaced, id, orderItems);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(datePlaced, other.datePlaced)
				&& Objects.equals(id, other.id) && Objects.equals(orderItems, other.orderItems);
	}
	
}
