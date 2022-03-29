package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

	private Long id;
	private String type;
	private String name;
	private String description;
	private Float cost;
	
	// Constructor with crucial fields
	public Item(String type, String name, Float cost) {
		this.type = type;
		this.name = name;
		this.cost = cost;
	}
	
	/*
	 * Constructor with all fields
	 */
	public Item(Long id, String type, String name, String description, Float cost) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.description = description;
		this.cost = cost;
	}
	

	/*
	 * Other constructors
	 */
	public Item(Long id, String type, String name, Float cost) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.cost = cost;
	}
	
	public Item(String type, String name, String description, Float cost) {
		super();
		this.type = type;
		this.name = name;
		this.description = description;
		this.cost = cost;
	}
	
	
	/*
	 * getters and setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	
	/*
	 * Generate the overrides for toString, hashCode and equals
	 */
	@Override
	public String toString() {
		return "Item [id=" + id + ", type=" + type + ", name=" + name + ", description=" + description + ", cost="
				+ cost + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, description, id, name, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(cost, other.cost) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}
	
	
	
	
	
}
