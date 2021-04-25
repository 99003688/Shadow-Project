package com.ltts.smartCafeteriacontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Model.JwtRequest;
import Services.customUserdetailsService;

@RestController
@CrossOrigin(origins="*")
public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private customUserdetailsService customerUserDetailsService;
	
	@Autowired
	private helper.jwtUtil jwtUtil;

	@RequestMapping(value="/token", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest ) throws Throwable{
		
		System.out.println(jwtRequest);
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
			
		}catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		catch(BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad credentials");
		}
		
		UserDetails userDetaisl=this.customerUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
	    String token = this.jwtUtil.generateToken(userDetaisl);
	    System.out.println("JWT "+token);
		return ResponseEntity.ok("Bad credentials") ;
	    
	    
	    
	}
}
