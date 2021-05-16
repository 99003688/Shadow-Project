package com.ltts.shadow.smartcafeteria.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "loginUser")
public class Login  {





	@Id
	@Column(name = "username" , nullable = false, length = 45)
	private String username;
	
	@Column(name = "password" , nullable = false, length = 45)
	private String password;
	
	 @CreationTimestamp
	    @Temporal(TemporalType.TIMESTAMP)
	     private Date date;
	
	

	
	
	
	


	

	public Login(String username, String password, Date date) {
		super();
		this.username = username;
		this.password = password;
		this.date = date;
	}


	


	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Login(String username, String password) {
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

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}





	@Override
	public String toString() {
		return "login [username=" + username + ", password=" + password + ", date=" + date + "]";
	}
}
