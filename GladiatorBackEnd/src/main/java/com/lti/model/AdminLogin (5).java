package com.lti.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADMIN_LOGIN")
public class AdminLogin implements Serializable{
	@Id
	@Column(name="USERNAME")
	private String username;
	@Column(name = "PASSWORD")
	private String password;
	
	public AdminLogin() {
		super();
		
	}

	public AdminLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminLogin [username=" + username + ", password=" + password + "]";
	}
	
	

}
