package com.ovsc.springboot.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ovsc.springboot.exception.ResourceNotFoundException;
import com.ovsc.springboot.model.Customer;
import com.ovsc.springboot.repository.CustomerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	// get all customers
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	// get customer by username
	@GetMapping("/customers/username/{username}")
	public ResponseEntity<Customer> getCustomerByUsername(@PathVariable String username) {
	  Customer customer = customerRepository.findByUsername(username)
	    .orElseThrow(() -> new ResourceNotFoundException("Customer not found with username: " + username));
	  return ResponseEntity.ok(customer);
	}

	
	// create customer
//	@PostMapping("/customers")
//	public Customer createCustomer(@RequestBody Customer customer) {
//		return customerRepository.save(customer);
//	}
	
	@PostMapping("/customers") 
	 public ResponseEntity<Customer> createCustomer(@RequestBody Customer user){  
	  Optional<Customer> customer = customerRepository.findByUsername(user.getUsername()); 
	 
	        if ( customer.isPresent() ) { 
	            return new ResponseEntity<Customer>(HttpStatus.FOUND); 
	        } 
	 
	        customerRepository.save(user); 
	 
	        return new ResponseEntity<Customer>(HttpStatus.OK); 
	         
	    }

	// get customer by id
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + id));
		return ResponseEntity.ok(customer);
	}

	// update customer
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + id));

		customer.setFirstName(customerDetails.getFirstName());
		customer.setLastName(customerDetails.getLastName());
		customer.setUsername(customerDetails.getUsername());
		customer.setEmailAddress(customerDetails.getEmailAddress());
		customer.setPassword(customerDetails.getPassword());
		customer.setResidenceAddress(customerDetails.getResidenceAddress());
		customer.setMobileNumber(customerDetails.getMobileNumber());

		Customer updatedCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updatedCustomer);
	}

	// delete customer
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + id));

		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
