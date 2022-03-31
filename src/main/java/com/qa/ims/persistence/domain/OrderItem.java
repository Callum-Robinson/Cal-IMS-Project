package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItem {

	private Long orderId;
	private Long itemId;
	private String itemType;
	private String itemName;
	private Double itemCost;
	private Integer quantity;
	
	
	/*
	 * Constructor with all fields
	 */
	public OrderItem(Long orderId, Long itemId, String itemType, String itemName, Double itemCost, Integer quantity) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.itemType = itemType;
		this.itemName = itemName;
		this.itemCost = itemCost;
		this.quantity = quantity;
	}
	
	
	/*
	 * Constructor with no order ID
	 */
	public OrderItem(Long itemId, String itemType, String itemName, Double itemCost, Integer quantity) {
		super();
		this.itemId = itemId;
		this.itemType = itemType;
		this.itemName = itemName;
		this.itemCost = itemCost;
		this.quantity = quantity;
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


	public String getItemType() {
		return itemType;
	}


	public void setItemType(String itemType) {
		this.itemType = itemType;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public Double getItemCost() {
		return itemCost;
	}


	public void setItemCost(Double itemCost) {
		this.itemCost = itemCost;
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
		return "OrderItem [orderId=" + orderId + ", itemId=" + itemId + ", itemType=" + itemType + ", itemName="
				+ itemName + ", itemCost=" + itemCost + ", quantity=" + quantity + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(itemCost, itemId, itemName, itemType, orderId, quantity);
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
		return Objects.equals(itemCost, other.itemCost) && Objects.equals(itemId, other.itemId)
				&& Objects.equals(itemName, other.itemName) && Objects.equals(itemType, other.itemType)
				&& Objects.equals(orderId, other.orderId) && Objects.equals(quantity, other.quantity);
	}
	
}
