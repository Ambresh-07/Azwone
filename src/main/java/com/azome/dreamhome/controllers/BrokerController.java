package com.azome.dreamhome.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azome.dreamhome.DTO.BrokerRequest;
import com.azome.dreamhome.entity.Broker;
import com.azome.dreamhome.services.BrokerService;

@RestController
@RequestMapping("/broker")
public class BrokerController {

	@Autowired
	BrokerService brokerService;

	// create broker
	
	@PostMapping("/create")
	public ResponseEntity<Broker> createBroker(@RequestBody Broker broker) {

		return new ResponseEntity<Broker>(brokerService.createBroker(broker), HttpStatus.CREATED);

	}

	// get all broker
	@GetMapping("/list")
	public ResponseEntity<List<Broker>> getAllBrokers() {
		return ResponseEntity.ok(brokerService.getAllBrokers());
	}

	// get broker by id
	@GetMapping("/{id}")
	public ResponseEntity<Broker> getBrokerById(@PathVariable Long id) {
		return ResponseEntity.ok(brokerService.getBrokerById(id));
	}

	// delete broker by id

	@DeleteMapping("/{id}")
	ResponseEntity<String> deleteBrokerById(@PathVariable Long id) {
		return ResponseEntity.ok(brokerService.deleteBrokerById(id));
	}

	// update broker by id

	@PutMapping("/{id}")
	public ResponseEntity<Broker> updateBrokerById(@RequestBody Broker broker, @PathVariable Long id) {
		return new ResponseEntity<Broker>(brokerService.updateBrokerById(broker, id), HttpStatus.CREATED);

	}
}
