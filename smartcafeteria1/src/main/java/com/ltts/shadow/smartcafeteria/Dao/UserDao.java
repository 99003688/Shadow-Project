package com.ltts.shadow.smartcafeteria.Dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltts.shadow.smartcafeteria.Models.User;

public interface UserDao extends JpaRepository<User, String> 
{
	
	public User findByUsername(String username);

	public User findByUsernameAndPassword(String username,String password);

	public List<User> findAll();

}
//	abstract public User findByUsername(String username);
//	abstract public User findByUsernameAndPassword(String username, String password);


