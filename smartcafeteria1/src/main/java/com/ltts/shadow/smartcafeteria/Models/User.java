package com.ltts.shadow.smartcafeteria.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "registeredusers")
public class User 
{
	
	
	@Id
	@Column(name = "fullname" , nullable = false, unique = true, length = 45)
	private String fullname;
	
	@Column(name = "company" , nullable = false, length = 45)
	private String company;
	
	@Column(name = "designation" , nullable = false, length = 45)
	private String designation;
	
	@Column(name = "username" , nullable = false, length = 45)
	private String username;
	
	@Column(name = "password" , nullable = false, length = 45)
	private String password;
	

	public User(String fullname, String company, String designation, String username, String password) {
		super();
		this.fullname = fullname;
		this.company = company;
		this.designation = designation;
		this.username = username;
		this.password = password;
	}

	public User() {
		super();
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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
		return "User [fullname=" + fullname + ", company=" + company + ", designation=" + designation + ", username="
				+ username + ", password=" + password + "]";
	}
	
	
}

	
