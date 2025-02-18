package com.ovsc.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.ovsc.springboot.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByUsername(String username);

}



