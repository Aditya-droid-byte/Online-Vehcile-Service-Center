package com.ovsc.springboot.controller;

import java.util.HashMap;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.ovsc.springboot.model.Request;
import com.ovsc.springboot.repository.RequestRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class RequestController {

	@Autowired
	private RequestRepository requestRepository;

	// get all requests
	@GetMapping("/requests")
	public List<Request> getAllRequests() {
		return requestRepository.findAll();
	}

	// create request rest api
	@PostMapping("/requests")
	public Request createRequest(@RequestBody Request request) {
		return requestRepository.save(request);
	}

	// get request by id rest api
	@GetMapping("/requests/{id}")
	public ResponseEntity<Request> getRequestById(@PathVariable Long id) {
		Request request = requestRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Request not exist with id :" + id));
		return ResponseEntity.ok(request);
	}

	// update request rest api
	@PutMapping("/requests/{id}")
	public ResponseEntity<Request> updateRequest(@PathVariable Long id, @RequestBody Request requestDetails) {
		Request request = requestRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Request not exist with id :" + id));

		request.setVehicleNumber(requestDetails.getVehicleNumber());
		request.setVehicleName(requestDetails.getVehicleName());
		request.setVehicleBrand(requestDetails.getVehicleBrand());
		request.setVehicleModel(requestDetails.getVehicleModel());
		request.setServiceType(requestDetails.getServiceType());
		request.setProblemDescription(requestDetails.getProblemDescription());
		request.setManufacturingDate(requestDetails.getManufacturingDate());

		Request updatedRequest = requestRepository.save(request);
		return ResponseEntity.ok(updatedRequest);
	}

	// delete request rest api
	@DeleteMapping("/requests/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteRequest(@PathVariable Long id) {
		Request request = requestRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Request not exist with id :" + id));

		requestRepository.delete(request);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}



