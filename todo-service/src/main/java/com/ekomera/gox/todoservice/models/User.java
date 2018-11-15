package com.ekomera.gox.todoservice.models;

import java.util.ArrayList;
import java.util.UUID;

public class User {
	private String id;



	private String username;
	private String password;
	private ArrayList<Todo> list;


	public User(String username) {
		this.username=username;
		id=UUID.randomUUID().toString();
		System.out.println(id);

	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	public void setList(ArrayList<Todo> list) {
		this.list=list;
	}
	public ArrayList<Todo> getList() {
		if(list==null) {
			return new ArrayList<Todo>();
		}
		return list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



}
