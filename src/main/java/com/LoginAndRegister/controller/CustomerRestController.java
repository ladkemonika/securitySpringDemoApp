package com.LoginAndRegister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoginAndRegister.entity.Customer;
import com.LoginAndRegister.service.CustomerService;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Customer c){
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(c.getEmail(),c.getPwd());
		
		//verify login detais valid or not 
	 Authentication authenticate = authManager.authenticate(token);
		
		boolean status = authenticate.isAuthenticated();
		
		if(status) {
			return new ResponseEntity<String>("welcome",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("failed",HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer c){
		
		boolean status = customerService.saveCustomer(c);
		if(status) {
			return new ResponseEntity<>("success",HttpStatus.CREATED);
			
		}else {
			return new ResponseEntity<>("failed",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
