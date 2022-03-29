package com.qa.ims.persistence.domain;

public class Item {

	private Long id;
	private String type;
	private String name;
	private String description;
	private Float cost;
	
	public Item(String type, String name, Float cost) {
		this.type = type;
		this.name = name;
		this.cost = cost;
	}

	public Item(Long id, String type, String name, String description, Float cost) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.description = description;
		this.cost = cost;
	}
	
	
}
