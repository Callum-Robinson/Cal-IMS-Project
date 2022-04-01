package com.qa.ims.persistence.domain;

public class OrderItem {

	private Long orderId;
	private Long itemId;
	private Integer quantity;
	
	private String itemType;
	private String itemName;
	private Double itemCost;
	
	
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

	
	public OrderItem(Long itemId, String itemType, String itemName, Double itemCost,  Integer quantity) {
		super();
		this.setItemId(itemId);
		this.setItemType(itemType);
		this.setItemName(itemName);
		this.setItemCost(itemCost);
		this.setQuantity(quantity);
	}

	
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


	@Override
	public String toString() {
		return "[Item Id = " + itemId + ", Item Type = " + itemType + ", Item Name = " + itemName + ", Item Cost = "
				+ itemCost + ", Quantity = " + quantity + "]";
	}

	
	
}
