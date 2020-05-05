package com.akademikwebapp.akademikwebapp;

public class User {
	
	private String username;
	
	private String password;
	
	private int enabled;
	
	private String authority;
	
	private int id;
	
	public User(String username, String password, int enabled, String authority , int id) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
		this.id = id;
	}

	public User() {

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

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
