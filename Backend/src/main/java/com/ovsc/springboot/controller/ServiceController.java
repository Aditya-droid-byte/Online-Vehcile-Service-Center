package com.ovsc.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ovsc.springboot.exception.ResourceNotFoundException;
import com.ovsc.springboot.model.Service;
import com.ovsc.springboot.repository.ServiceRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ServiceController {

	@Autowired
	private ServiceRepository serviceRepository;

	@GetMapping("/services")
	public List<Service> getServices() {
		return serviceRepository.findAll();
	}

}



