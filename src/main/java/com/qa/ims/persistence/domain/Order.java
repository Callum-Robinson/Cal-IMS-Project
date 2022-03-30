package com.qa.ims.persistence.domain;

import java.sql.Date;
import java.util.Objects;

public class Order {
	
	private Long id;
	private Long customerId;
	private Date datePlaced;
	
	
	/*
	 * Constructors
	 */
	public Order(Long id, Long customerId, Date datePlaced) {
		super();
		this.setId(id);
		this.setCustomerId(customerId);
		this.setDatePlaced(datePlaced);
	}
	
	
	
	public Order(Long customerId, Date datePlaced) {
		super();
		this.setCustomerId(customerId);
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


	public Date getDatePlaced() {
		return datePlaced;
	}


	public void setDatePlaced(Date datePlaced) {
		this.datePlaced = datePlaced;
	}



	
	/*
	 * Generate the toString, hashcode and equals overrides
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + ", datePlaced=" + datePlaced + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(customerId, datePlaced, id);
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
				&& Objects.equals(id, other.id);
	}
	
	
	
	
	
}
