package com.pojo;



public class User {
	private String name;
	private String username;
	private String emailId;
	private String password;
	private double contact;
	public User() {
		super();
	}
	
	
	public User(String name, String username, String emailId, String password, double contact) {
		super();
		this.name = name;
		this.username = username;
		this.emailId = emailId;
		this.password = password;
		this.contact = contact;
	}


	public double getContact() {
		return contact;
	}
	public void setContact(double contact) {
		this.contact = contact;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", username=" + username + ", emailId=" + emailId + ", contact=" + contact
				+ ", password=" + password + "]";
	}
	
	
	

}
