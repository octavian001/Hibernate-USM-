package com.service.auto;

import java.beans.ConstructorProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class USERS {
	
	@Id
	@GeneratedValue
	@Column(name = "id_user", nullable = false, unique = true)
	private Integer user_id;
	
	@Column(name = "user", nullable = false, unique = true)
	private String user;
	
	@Column(name = "password", nullable = false, unique = true)
	private String password;
	
	@Column(name = "role", nullable = false, unique = true)
	private String role;

	public USERS(){
		
	}
	

	public USERS(int user_id, String user, String password, String role) {
		super();
		this.user_id = user_id;
		this.user = user;
		this.password = password;
		this.role = role;
	}


	public Integer getUser_id() {
		return user_id;
	}


	public String getUser() {
		return user;
	}


	public String getPassword() {
		return password;
	}


	public String getRole() {
		return role;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
}
