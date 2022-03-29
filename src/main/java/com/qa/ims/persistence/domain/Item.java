package com.qa.ims.persistence.domain;

public class Item {

	private Long id;
	private String type;
	private String name;
	private String description;
	private Float cost;
	
	// Constructor with needed fields
	public Item(String type, String name, Float cost) {
		this.type = type;
		this.name = name;
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
	
	public Item(Long id, String type, String name, String description, Float cost) {
		this.id = id;
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
	
	
	
	
}
