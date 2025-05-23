package com.LoginAndRegister.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.LoginAndRegister.entity.Customer;

import com.LoginAndRegister.repo.CustomerRepository;

@Service
public class CustomerService  implements UserDetailsService{
   
	@Autowired
	 private BCryptPasswordEncoder pwdEncoder ;
	
	@Autowired
	 private CustomerRepository customerRepo;
	
	 public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		 
		 Customer c = customerRepo.findByEmail(email);
		 return new User(c.getEmail(),c.getPwd(),Collections.emptyList());
	 }
	 
	 
	 public boolean saveCustomer(Customer c) {
	 
	 String encodedPwd = pwdEncoder.encode(c.getPwd());
	 c.setPwd(encodedPwd);
	 
	 Customer savedCustomer = customerRepo.save(c);
	 
	 return savedCustomer.getCid() != null;
}
}