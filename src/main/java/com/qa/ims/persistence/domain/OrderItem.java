package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItem {

	private Long orderId;
	private Long itemId;
	private Integer quantity;
	
	private String itemType;
	private String itemName;
	private Double itemCost;
	private Double totalCostOfItem;
	
	
	
	
	/*
	 * OrderItem constructors 
	 */
	public OrderItem(Long orderId, Long itemId, Integer quantity) {
		super();
		this.setOrderId(orderId);
		this.setItemId(itemId);
		this.setQuantity(quantity);
	}


	public OrderItem(Long itemId, Integer quantity) {
		super();
		this.setItemId(itemId);
		this.setQuantity(quantity);
	}

	
	public OrderItem(Long itemId, String itemType, String itemName, Double itemCost,  Integer quantity , Double totalCostOfItem) {
		super();
		this.setItemId(itemId);
		this.setItemType(itemType);
		this.setItemName(itemName);
		this.setItemCost(itemCost);
		this.setQuantity(quantity);
		this.setTotalCostOfItem(totalCostOfItem);
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
	
	
	public Double getTotalCostOfItem() {
		return totalCostOfItem;
	}


	public void setTotalCostOfItem(Double totalCostOfItem) {
		this.totalCostOfItem = totalCostOfItem;
	}


	
	
	/*
	 * Generate override for toString and edited for easier reading of output
	 */
	@Override
	public String toString() {
		return "[Item Id: " + itemId + ", Item Type: " + itemType + ", Item Name: " + itemName + ", Item Cost: "
				+ itemCost + ", Quantity: " + quantity + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(itemCost, itemId, itemName, itemType, orderId, quantity, totalCostOfItem);
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
				&& Objects.equals(orderId, other.orderId) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(totalCostOfItem, other.totalCostOfItem);
	}

	
	
}
