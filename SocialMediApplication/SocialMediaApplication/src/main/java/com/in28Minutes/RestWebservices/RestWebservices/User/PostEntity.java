package com.in28Minutes.RestWebservices.RestWebservices.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "PostEntity")
public class PostEntity {
	
	
	@Id
	@GeneratedValue
	private int id;
	private String description;
	
	@ManyToOne
	private UserBean user;
	
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
