package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItem {

	private Long orderId;
	private Long itemId;
	private Integer quantity;
	
	
	/*
	 * Constructor with all fields
	 */
	public OrderItem(Long orderId, Long itemId, Integer quantity) {
		super();
		this.setOrderId(orderId);
		this.setItemId(itemId);
		this.setQuantity(quantity);
	}


	/*
	 * Getters and Setters
	 */
	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public Long getItemId() {
		return itemId;
	}


	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	/*
	 * Generate the overrides for toString, hashCode and equals
	 */
	@Override
	public String toString() {
		return "OrderItem [orderId=" + orderId + ", itemId=" + itemId + ", quantity=" + quantity + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(itemId, orderId, quantity);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(orderId, other.orderId)
				&& Objects.equals(quantity, other.quantity);
	}
	
	
}
