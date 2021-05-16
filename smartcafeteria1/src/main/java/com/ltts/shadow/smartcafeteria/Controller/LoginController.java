package com.ltts.shadow.smartcafeteria.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltts.shadow.smartcafeteria.Dao.LoginDao;
import com.ltts.shadow.smartcafeteria.Dao.UserDao;
import com.ltts.shadow.smartcafeteria.Models.Login;
import com.ltts.shadow.smartcafeteria.Models.User;
import com.ltts.shadow.smartcafeteria.Services.UserService;




@CrossOrigin("http://localhost:4200")
@RestController
public class LoginController {

	@Autowired
	UserDao UserRep;
	
	@Autowired
	LoginDao logind;
	
	@Autowired
	UserService UserSer;

	@RequestMapping("/users")
	public List<User> makeList()
	{
		List<User> ls =UserRep.findAll();
		return ls;
	}


	
	@PostMapping("/crusers")
	public User create(@RequestBody User us) {
		
		return UserRep.save(us);
	}
	
	
	@PostMapping("/login")
	public User LoginUser(@RequestBody User us) throws Exception
	{
		String tempUsername=us.getUsername();
		String tempPassword=us.getPassword();
		User userObj=null;
		
		if(tempUsername!=null && tempPassword!=null)
		{
			userObj=UserSer.FetchUserByUsernameAndPassword(tempUsername, tempPassword);
			Login log=new Login(us.getUsername(),us.getPassword());
			logind.save(log);
			
		}
		if(userObj==null)
		{
			throw new Exception("Bad Credentials");
		}
		return userObj;
	}
	
}
