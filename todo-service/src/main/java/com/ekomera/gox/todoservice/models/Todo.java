package com.ekomera.gox.todoservice.models;

import java.util.UUID;

public class Todo {
	private String description;
	private String category;
	private boolean status;
	private String id;

	public Todo(String description, String category) {
		this.category=category;
		this.description = description;
		this.status=false;
		id=UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id=id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String name) {
		this.description = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return String.format("[#name:#%s#category:#%s#status:#%s]", description, category, status);
	}

}