package com.authentication.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class UserModel{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	
	public UserModel() {
		// TODO Auto-generated constructor stub
	}
	public UserModel(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	public Number getId() {
		return id;
	}

	public void setId(Number id) {
		this.id = (int) id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
