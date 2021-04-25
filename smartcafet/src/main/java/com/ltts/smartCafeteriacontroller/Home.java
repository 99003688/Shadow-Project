package com.ltts.smartCafeteriacontroller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@CrossOrigin(origins="*")
public class Home {

	@RequestMapping("/welcome")
	public String welcome() {
		String text="this page iis private";
		return text;
	}
	
	
	@RequestMapping("/getusers")
	public String getUsers() {
		
		return "{\"name\":\"user\"}";
	}
}
