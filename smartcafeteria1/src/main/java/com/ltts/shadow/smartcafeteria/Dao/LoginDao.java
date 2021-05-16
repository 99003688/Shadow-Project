package com.ltts.shadow.smartcafeteria.Dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ltts.shadow.smartcafeteria.Models.Login;

public interface LoginDao extends JpaRepository<Login, String> {
	
	@Query("SELECT u FROM Login u WHERE u.username = ?1")
	public Login findByUsername(String username);

 
}
