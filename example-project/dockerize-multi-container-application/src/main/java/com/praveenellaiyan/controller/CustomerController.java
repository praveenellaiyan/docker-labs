/**
 * 
 */
package com.praveenellaiyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.praveenellaiyan.dao.CustomerRepository;
import com.praveenellaiyan.model.Customer;

/**
 * @author praveenellaiyan
 *
 */
@RestController()
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/health")
	public ResponseEntity<String> healthCheck() {
		return ResponseEntity.ok("All Good!");
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/all")
	public Iterable<Customer> getAllUsers() {
		return customerRepository.findAll();
	}
}
