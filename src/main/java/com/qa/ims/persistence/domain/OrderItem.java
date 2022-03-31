package com.qa.ims.persistence.domain;

public class OrderItem {

	private Long orderId;
	private Long itemId;
	private Integer quantity;
	
	
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


	@Override
	public String toString() {
		return "OrderItem [itemId=" + itemId + ", quantity=" + quantity + "]";
	}
	
	
}
