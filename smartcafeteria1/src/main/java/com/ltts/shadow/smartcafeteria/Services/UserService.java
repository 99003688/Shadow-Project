package com.ltts.shadow.smartcafeteria.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltts.shadow.smartcafeteria.Dao.UserDao;
import com.ltts.shadow.smartcafeteria.Models.User;

@Service
public class UserService
{
	@Autowired
	private UserDao UserRep;
	
	public User FetchUserByUsernameAndPassword(String username, String password)
	{
		return UserRep.findByUsernameAndPassword(username, password);
	}
}