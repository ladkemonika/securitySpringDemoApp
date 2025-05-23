package com.LoginAndRegister.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LoginAndRegister.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	public Customer findByEmail(String email);

	
}
